package com.abc.thread.two_phase;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 9:59
 */
public class Main {
  public static void main(String[] args){
    System.out.println("main: begin===>");
    try{
      // startup the thread
      CountupThread countupThread = new CountupThread();
      countupThread.start();

      // wait a moment
      TimeUnit.MILLISECONDS.sleep(10000);
      countupThread.shutdownRequest();

      // wait to stop
      countupThread.join();

    }catch (Exception e){
      e.printStackTrace();
    }
    System.out.println("main: END");
  }
}
