package com.abc.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: Interrupt
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 15:56
 */
public class Interrupt {
  public static void main(String[] args)  {

  }

  public static void testInterrupt() throws InterruptedException {
    Thread thread = new Thread(()->{
      System.out.println("i am start working===>");
      while(!Thread.currentThread().isInterrupted()){
        System.out.println("i am working ====>");
      }
      System.out.println("i am existing===>");
    });

    //启动线程
    thread.start();
    TimeUnit.MINUTES.sleep(1);
    System.out.println("System will be shutdown");
    thread.interrupt();
  }
}
