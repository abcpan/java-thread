package com.abc.thread.visibility;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/9 16:26
 */
public class Novisibility {
  public static volatile int number;
  public static volatile boolean  ready = false;

  public static void main(String[] args) throws InterruptedException {
    new Thread(()->{
      int i = 0;
      while(i <20000){
        System.out.println(number);
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        i++;
      }
    }).start();

//    //修改变量

    number = 3;
    TimeUnit.SECONDS.sleep(2);
    ready = true;
  }
}
