package com.abc.thread.thread_per_message;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 14:49
 */
public class Helper {
  public void handle(int count,char c) throws InterruptedException {
    System.out.println("  handle (" + count + ", " + c + ") BEGIN" );
    for(int i = 0; i< count; i++){
      TimeUnit.MILLISECONDS.sleep(100);
      System.out.println(c);
    }
    System.out.println("");
    System.out.println("  handle (" + count + ", " + c + ") END");
  }
}
