package com.abc.thread.threadpool;

import java.util.LinkedList;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 10:29
 */
public class LinkedRunnableQueue implements RunnableQueue {
  // 任务队列的最大容量 再初始化时传入
  private final int limit;

  // 任务队列的拒绝策略，如果满了将会执行
  private final DenyPolicy denyPolicy;

  // 存放任务的队列
  private final LinkedList<Runnable> runnableList = new LinkedList<>();

  // 线程池
  private final ThreadPool threadPool;

  public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
    this.limit = limit;
    this.denyPolicy = denyPolicy;
    this.threadPool = threadPool;
  }

  /**
   * 添加任务
   * @param runnable
   */
  @Override
  public void offer(Runnable runnable) {
    synchronized(this.runnableList){
      // 无法容纳新任务时执行拒绝策略
      if(this.runnableList.size() >= this.limit){
        denyPolicy.reject(runnable,this.threadPool);
      }else{
        // 将任务放到队尾，并唤醒阻塞中的进程(take 任务线程)
        runnableList.addLast(runnable);
        runnableList.notifyAll();
      }

    }
  }

  /**
   *
   * @return
   */
  @Override
  public Runnable take() throws InterruptedException {
    synchronized (this.runnableList){
      while(runnableList.isEmpty()){
        // 如果任务队列中没有可执行的任务 则当前线程将会挂起，进入runnableList关联的monitor waitset 中等待唤醒
        try {
          runnableList.wait();
        } catch (InterruptedException e) {
         throw e;
        }
      }
      return runnableList.removeFirst();
    }
  }

  /**
   * 任务数量大小
   * @return
   */
  @Override
  public int size() {
    synchronized (runnableList){
      return runnableList.size();
    }
  }
}
