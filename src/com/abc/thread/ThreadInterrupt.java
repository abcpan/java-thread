package com.abc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: ThreadInterruption
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/3 23:42
 */
public class ThreadInterrupt {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(()->{
      while(true){
        //System.out.println("I am running...");
        try {
          TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });
    thread.start();
    TimeUnit.MILLISECONDS.sleep(2);
    thread.interrupt();
    System.out.println(thread.isInterrupted());
  }
}
