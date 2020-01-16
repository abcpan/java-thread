package com.abc.thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 11:49
 */
public class Mytask implements Runnable {
  private static final int PHASES = 5;
  private final CyclicBarrier phaseBarrier;
  private final CountDownLatch doneLatch;
  private final int context;
  private final static Random random = new Random(314159);

  public Mytask(CyclicBarrier barrier,CountDownLatch latch,int context){
    this.phaseBarrier = barrier;
    this.doneLatch = latch;
    this.context = context;
  }

  @Override
  public void run() {
    try{
      for(int phase = 0;phase< PHASES; phase ++){
        doPhase(phase);
        phaseBarrier.await();
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }catch (BrokenBarrierException e){
      e.printStackTrace();
    }finally {
      doneLatch.countDown();
    }
  }
  protected void doPhase(int phase) {
    String name = Thread.currentThread().getName();
    System.out.println(name + ":MyTask:BEGIN:context = " + context + ", phase = " + phase);
    try {
      TimeUnit.MILLISECONDS.sleep(random.nextInt(3000));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      System.out.println(name + ":MyTask:END:context = " + context + ", phase = " + phase);
    }
  }
}
