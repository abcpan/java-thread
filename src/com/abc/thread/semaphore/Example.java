package com.abc.thread.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 17:10
 */
public class Example {
  // 日志打印
  static class Log{
    public static void println(String s){
      System.out.println(Thread.currentThread().getName() + ":" + s);
    }
  }

  // 资源数量
  static class BoundedResource{
    private final Semaphore semaphore;
    private final int permits;

    // 构造函数
    public BoundedResource(int permits){
      this.semaphore = new Semaphore(permits);
      this.permits = permits;
    }

    // 使用资源
    public void use() throws InterruptedException {
      semaphore.acquire();
      try{
        doUse();
      }finally {
        semaphore.release();
      }
    }

    // 实际使用资源
    protected void doUse() throws InterruptedException {
      Log.println("BEGIN: used===>" + (permits-semaphore.availablePermits()));
      TimeUnit.SECONDS.sleep(2);
      Log.println("END: used===>" + (permits-semaphore.availablePermits()));
      StringBuilder stringBuilder = new StringBuilder();
    }
  }

  // 使用资源的线程
  static class Worker extends Thread{
    private final BoundedResource resource;
    public Worker(BoundedResource resource){
      this.resource = resource;
    }

    @Override
    public void run() {
      try {
        while(true){
          resource.use();
        }

      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  public static void main(String [] args){
    BoundedResource resource = new BoundedResource(3);
    for(int i = 0;i<10;i++){
      new Worker(resource).start();
    }
  }
}
