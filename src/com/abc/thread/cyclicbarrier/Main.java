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
    // 线程池
    ExecutorService service= Executors.newFixedThreadPool(THREADS);
    
    // 栅栏
    CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, () -> {
      System.out.println("栅栏 动作");
    });

    // confirm the job is done
    CountDownLatch doneLatch  = new CountDownLatch(THREADS);
    try{
      // start work
      for(int i= 0;i< THREADS;i++){
        service.execute(new Mytask(phaseBarrier,doneLatch,i));
      }
      System.out.println("在此处等待所有任务完成-->");
      doneLatch.await();
    }catch (Exception e){

    }finally {
      service.shutdown();
      System.out.println("END===>");
    }
  }
}
