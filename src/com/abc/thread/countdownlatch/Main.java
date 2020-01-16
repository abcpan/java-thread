package com.abc.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 10:41
 */
public class Main {
  private static final int TASKS = 10;  // worker number

  public static void main(String[] args){
    System.out.println("BEGIN===>");
    ExecutorService service = Executors.newFixedThreadPool(5);
    CountDownLatch doneLatch  = new CountDownLatch(TASKS);
    try{
      for(int i = 0;i < TASKS;i++){
        service.execute(new Mytask(doneLatch,i));
      }
      System.out.println("WAITING===>");

      // wait work is done
      doneLatch.await();
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      service.shutdown();
      System.out.println("END");
    }
  }
}
