package com.abc.thread.hook;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: TreadHook
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 19:11
 */
public class TreadHook {
  public static void main(String[] args){
    Runtime.getRuntime().addShutdownHook(new Thread(()->{
      try {
        System.out.println("The hook thread 1 is running");
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread hook thread 1 will exit");
    }));
    Runtime.getRuntime().addShutdownHook(new Thread(()->{
      try {
        System.out.println("The hook thread 2 is running");
        TimeUnit.SECONDS.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread hook thread 2 will exit");
    }));
  }
}
