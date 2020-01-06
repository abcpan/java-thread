package com.abc.thread.threadpool;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 14:30
 */
public class ThreadPoolExample {
  public static void main(String[] args) throws InterruptedException {
    final ThreadPool threadPool = new BasicThreadPool(2,6,4,1000);
    //定义20 个线程 提交给线程池
    for(int i = 0 ;i<20;i++){
      threadPool.execute(()->{
        try {
          TimeUnit.SECONDS.sleep(10);
          System.out.println(Thread.currentThread().getName() +" is running done.");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }

    // 不断给出输出线程池的信息
    for(;;){
      System.out.println("getActiveCount" + threadPool.getActiveSize());
      System.out.println("getQueueSize" + threadPool.getQueueSize());
      System.out.println("getCoreSize" + threadPool.getCoreSize());
      System.out.println("getMaxSize" + threadPool.getMaxSize());
      System.out.println("getActiveCount" + threadPool.getActiveSize());
      TimeUnit.SECONDS.sleep(5);
    }
  }
}
