package com.abc.thread.eventqueue;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: EventClient
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 23:14
 */
public class EventClient {
  public static void main(String[] args){
    final EventQueue eventQueue = new EventQueue();
    //添加事件线程
    new Thread(()->{
      while(true){
        eventQueue.offer(new EventQueue.Event());
      }
    },"Producer thread").start();

    // 消费事件线程
    new Thread(()->{
      while(true){
        eventQueue.take();
        try {
          TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    },"Consumer thread").start();
  }
}
