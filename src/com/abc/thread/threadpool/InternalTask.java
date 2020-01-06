package com.abc.thread.threadpool;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 10:20
 */
public class InternalTask implements Runnable {
  private final RunnableQueue runnableQueue;
  private volatile boolean running = true;
  public InternalTask(RunnableQueue runnableQueue){
    this.runnableQueue = runnableQueue;
  }
  @Override
  public void run() {
    // 如果当前线程为running 且没有被中断，则其不断从queue中获取runnable,然后执行run方法
    while(this.running && !Thread.currentThread().isInterrupted()){
      try{
        Runnable task = this.runnableQueue.take();
        task.run();
      }catch (InterruptedException e){
        e.printStackTrace();
      }
    }
  }
  // 停止方法
  public void stop(){
    this.running = false;
  }
}
