package com.abc.thread;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/4 9:53
 */
public class ThreadJoin {
  public static void main(String[] args) throws InterruptedException {
    //线程池
    List<Thread> threads = IntStream.rangeClosed(1,2).mapToObj(ThreadJoin::createThread).collect(Collectors.toList());
    //启动每个线程
    threads.forEach(t->t.start());
    //对每个线程join
    for(Thread thread:threads){
      thread.join();
    }

    //main线程
    for(int i=0;i<10;i++){
      System.out.println(Thread.currentThread().getName() + "===>" + i);
      shortSleep();
    }
  }

  /**
   * 创建线程
   * @param seq
   * @return
   */
  public static Thread createThread(int seq){
    return new Thread(()->{
      for(int i = 0;i<10;i++){
        System.out.println(Thread.currentThread().getName() + "===>" + i);
        shortSleep();
      }
    },String.valueOf(seq));
  }
  // 构造一个线程 每个线程只是简单的循环输出
  public static void shortSleep(){
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
