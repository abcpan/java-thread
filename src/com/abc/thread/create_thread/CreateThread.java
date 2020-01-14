package com.abc.thread.create_thread;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 13:59
 */
public class CreateThread {
  public static void main(String[] args) throws InterruptedException {
    Thread t1 = new MyThread();
    Thread t2 = new MyThread();
    t1.start();
    t2.start();
    for(int i = 0;i<100000;i++){
      System.out.println("主线程==>"+Thread.currentThread().getName());
      TimeUnit.SECONDS.sleep(1);
    }
  }
  static class MyThread extends Thread{
    @Override
    public void run() {
      for(int i = 0;i<100;i++){
        System.out.println(Thread.currentThread().getName() + i);
        try {
          TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
