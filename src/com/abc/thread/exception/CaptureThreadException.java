package com.abc.thread.exception;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: CaptureThreadException
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 18:40
 */
public class CaptureThreadException {
  public static void main(String[] args){
    Thread.setDefaultUncaughtExceptionHandler((thread,throwable)->{
      System.out.println(thread.getName() + "occur exception");
      throwable.printStackTrace();
    });

    Thread t = new Thread(()->{
      try {
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(1/0);
    },"Test-Thread");
    t.start();
  }
}
