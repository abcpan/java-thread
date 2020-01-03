package com.abc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/3 17:16
 */
public class NewMusic {
  public static void main(String[] args){
    new Thread(()->browseNews()).start();
    new Thread(()->enjoyMusic()).start();
  }
  public static void browseNews(){
    for(;;){
      System.out.println("browser news ===>");
      sleep(1);
    }
  }
  public static void enjoyMusic(){
    for(;;){
      System.out.println("listening music===>");
      sleep(1);
    }
  }
  public static void sleep(int time){
    try {
      TimeUnit.SECONDS.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
