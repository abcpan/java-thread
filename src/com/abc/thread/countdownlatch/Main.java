package com.abc.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    timeTasks(5, ()->{
      String threadName = Thread.currentThread().getName();
      try {
        TimeUnit.MILLISECONDS.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("current tread name ---->" + threadName);
    });
  }
  public static void timeTasks(int threadCount, Runnable task) throws InterruptedException {
    CountDownLatch startLatch = new CountDownLatch(1);
    CountDownLatch endLatch = new CountDownLatch(threadCount);
    for(int i = 0; i< threadCount; i++){
      Thread t = new Thread(()-> {
        try {
          System.out.println(Thread.currentThread().getName() + "ready...");
          startLatch.await();
          task.run();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }finally {
          endLatch.countDown();
        }
      });
      t.start();
    }
    System.out.println("open the latch, all task begin,--->");
    startLatch.countDown();
    endLatch.await();
    System.out.println("all task end");
    
  }
}
