package com.abc.thread.future;

import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/15 23:22
 * @project IntelliJ IDEA
 */
public class Main {
  public static void main(String[] args){
    System.out.println("MAIN BEGIN===>");
    Host host = new Host();
    Data data1 = host.request(10,'A');
    Data data2 = host.request(20,'B');
    Data data3 = host.request(30,'C');
    Data data4 = host.request(40,'D');
    System.out.println("OTHER JOB BEGIN===>");
    try {
      TimeUnit.MILLISECONDS.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("data1===> " + data1.getContent());
    System.out.println("data2===> " + data2.getContent());
    System.out.println("data3===> " + data3.getContent());
    System.out.println("data4===> " + data4.getContent());
    System.out.println("MAIN END===>");
  }
}
