package com.abc.thread.threadpool;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 10:49
 */
public class BasicThreadPool extends Thread implements ThreadPool {
  // 初始化线程数量
  private final int initSize;

  // 线程最大数量
  private final int maxSize;
  // 核心数量
  private final int coreSize;
  // 线程活跃数量
  private  int activeCount;

  private final long keepAliveTime;
  private final TimeUnit timeUnit;
  // 创建线程所需工厂
  private final ThreadFactory threadFactory;

  // 任务队列
  private final RunnableQueue runnableQueue;

  // 线程池是否被关闭
  private volatile boolean isShutdown = false;

  // 工作线程队列
  private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();

  private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

  private final static ThreadFactory DEFAULT_TREAD_FACTORY = new DefaultThreadFactory();

  public BasicThreadPool(
      int initSize,
      int maxSize,
      int coreSize,
      int queueSize){
    this(
        initSize,
        maxSize,
        coreSize,
        queueSize,
        DEFAULT_TREAD_FACTORY,
        DEFAULT_DENY_POLICY,
        10,
        TimeUnit.SECONDS
    );
  }
  public BasicThreadPool(
      int initSize,
      int maxSize,
      int coreSize,
      int queueSize,
      ThreadFactory factory,
      DenyPolicy denyPolicy,
      long keepAliveTime,
      TimeUnit timeUnit
  ){
    this.initSize  = initSize;
    this.maxSize = maxSize;
    this.coreSize = coreSize;
    this.threadFactory = factory;
    this.timeUnit = timeUnit;
    this.keepAliveTime = keepAliveTime;
    this.runnableQueue = new LinkedRunnableQueue(queueSize,denyPolicy,this);
    // 初始化
    this.init();
  }

  /**
   * 初始化时先创建initSize 个线程
   */
  private void init(){
    start();
    for(int i=0;i<initSize; i++){

      newThread();
    }
  }

  /**
   * 提交任务
   * @param runnable
   */
  @Override
  public void execute(Runnable runnable) {
    if(this.isShutdown){
      throw new IllegalStateException("the thread is destroyed");
    }
    this.runnableQueue.offer(runnable);
  }

  @Override
  public void shutdown() {
    synchronized (this){
      if(this.isShutdown){
        return;
      }
      // 关闭标志置为true
      this.isShutdown = true;
      // 遍历所有任务 全部打断
      this.threadQueue.forEach(threadTask->{
        threadTask.internalTask.stop();
        threadTask.thread.interrupt();
      });
      //本身打断
      this.interrupt();
    }
  }

  @Override
  public int getInitSize() {
    if(this.isShutdown){
      throw new IllegalStateException("Thread pool is destroy");
    }
    return this.initSize;
  }

  @Override
  public int getMaxSize() {
    if(this.isShutdown){
      throw new IllegalStateException("Thread pool is destroy");
    }
    return this.maxSize;
  }

  @Override
  public int getCoreSize() {
    if(this.isShutdown){
      throw new IllegalStateException("Thread pool is destroy");
    }
    return this.coreSize;
  }

  @Override
  public int getQueueSize() {
    if(this.isShutdown){
      throw new IllegalStateException("Thread pool is destroy");
    }
    return this.runnableQueue.size();
  }

  @Override
  public int getActiveSize() {
     synchronized (this){
       return this.activeCount;
     }
  }

  @Override
  public boolean isShutdown() {
    return this.isShutdown;
  }

  /**
   *创建新线程
   */
  private void newThread(){

    InternalTask internalTask = new InternalTask(runnableQueue);
    Thread thread = this.threadFactory.createThread(internalTask);
    // 线程 和线程背后的runnable
    ThreadTask threadTask = new ThreadTask(thread,internalTask);
    //放入线程队列
    this.threadQueue.offer(threadTask);
    this.activeCount++;
    // 线程执行时 会从任务队列中取出一个任务执行
    thread.start();
  }

  public void removeThread(){
    ThreadTask threadTask = threadQueue.remove();
    threadTask.internalTask.stop();
    this.activeCount--;
  }

  /**
   * ThreadTask 只是InternalTask和task 的一个组合
   *
   */
  private static class ThreadTask{
    private Thread thread;
    private InternalTask internalTask;
    public ThreadTask(Thread thread,InternalTask internalTask){
      this.thread = thread;
      this.internalTask = internalTask;
    }
  }

  private static class DefaultThreadFactory implements ThreadFactory{
    private static final AtomicInteger GROUP_COUNTER = new AtomicInteger(1);
    private static final ThreadGroup group = new ThreadGroup("MyThreadPool-"+ GROUP_COUNTER.getAndDecrement());
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    @Override
    public Thread createThread(Runnable runnable) {
      return new Thread(group,runnable,"thread-pool-"+ COUNTER.getAndDecrement());
    }
  }
}
