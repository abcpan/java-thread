package com.abc.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/9 11:30
 */
public class AtomicExample {
  private static final AtomicLong counter = new AtomicLong(0);
  public static void main(String[] args){
    new Thread(()->{
      for(int i=0;i<20;i++){
        long result = counter.incrementAndGet();
        System.out.println("增加中线程===1==>"+result);
      }

    }).start();
    new Thread(()->{
      for(int i=0;i<20;i++){
        long result = counter.incrementAndGet();
        System.out.println("增加中线程===2==>"+result);
      }
    }).start();
  }
}
