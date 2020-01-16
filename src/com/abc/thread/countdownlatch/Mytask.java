package com.abc.thread.countdownlatch;

import com.abc.thread.threadpool.RunnableQueue;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 10:46
 */
public class Mytask implements Runnable {
  private final CountDownLatch doneLatch;
  private final int context;
  private static final Random random = new Random(314159);
  public Mytask(CountDownLatch latch,int context){
    this.doneLatch = latch;
    this.context = context;
  }
  @Override
  public void run() {
    dowTask();
    doneLatch.countDown();
  }

  // work
  private void dowTask(){
    String name = Thread.currentThread().getName();
    System.out.println("name" + ":MyTask:BEGIN:context" + context);
    try {
      TimeUnit.MILLISECONDS.sleep(random.nextInt(3000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      System.out.println(name + ":Mytask:END:context = " + context);
    }
  }
}
