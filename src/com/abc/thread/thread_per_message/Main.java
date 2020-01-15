package com.abc.thread.thread_per_message;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 14:38
 */
public class Main {
  public static void main(String[] args){
    System.out.println("MAIN BEGIN");
    Host host = new Host();
    host.request(20,'B');
    host.request(30,'C');
    host.request(40,'D');
    host.request(10,'A');
    System.out.println("main END");
  }
}
