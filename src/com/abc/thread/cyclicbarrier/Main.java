package com.abc.thread.cyclicbarrier;

import java.util.concurrent.*;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 10:59
 */
public class Main {
  private static final int THREADS = 3;
  public static void main(String[] args){
    System.out.println("BEGIN====>");
    // THREAD POOL
    ExecutorService service= Executors.newFixedThreadPool(THREADS);
    // the operation when barrier is done

    Runnable barrierAction = ()->{
      System.out.println("Barrier Action!");
    };

    CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS,barrierAction);

    // confirm the job is done
    CountDownLatch doneLatch  = new CountDownLatch(THREADS);
    try{
      // start work
      for(int i= 0;i< THREADS;i++){
        service.execute(new Mytask(phaseBarrier,doneLatch,i));
      }
      System.out.println("WAITING===>");
      doneLatch.await();
      //wait the job is end
    }catch (Exception e){

    }finally {
      service.shutdown();
      System.out.println("END===>");
    }
  }
}
