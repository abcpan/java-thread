package com.abc.thread.eventqueue;

import java.util.LinkedList;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: EventQueue
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 22:58
 */
public class EventQueue {

  static class Event{
  }
  private final LinkedList<Event> eventQueue = new LinkedList<>();
  private final static int DEFAULT_MAX_EVENT = 10;
  private final int max;
  public EventQueue(){
    this(DEFAULT_MAX_EVENT);
  }
  public EventQueue(int max){
    this.max = max;
  }

  /**
   * 添加事件
   * @param event
   */
  public void offer(Event event){
    synchronized(eventQueue){
      if(eventQueue.size() >=max){
        try {
          console("the queue is full");
          eventQueue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      //进行其他操作
      console("the new event is submitted");
      eventQueue.addLast(event);
      //通知
      this.eventQueue.notify();
    }
  }

  /**
   * 处理事件
   * @return
   */
  public Event take(){
    synchronized(eventQueue){
      if(eventQueue.isEmpty()){
        try {
          console("the queue is empty");
          eventQueue.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      // 其他操作
      Event event = eventQueue.removeFirst();
      this.eventQueue.notify();
      console("the event " + event + "is handled");
      return event;
    }
  }
  private void console(String msg){
    System.out.printf("%s:%s\n",Thread.currentThread().getName(),msg);
  }
}
