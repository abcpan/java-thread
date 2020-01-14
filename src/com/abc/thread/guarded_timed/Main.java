package com.abc.thread.guarded_timed;

import java.util.concurrent.TimeoutException;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 10:15
 */
public class Main {
  public static void main(String[] args){
    Host host = new Host(10000);
    System.out.println("BEGIN===>");
    try {
      host.execute();
    } catch (TimeoutException | InterruptedException e) {
      e.printStackTrace();
    }
  }
}
