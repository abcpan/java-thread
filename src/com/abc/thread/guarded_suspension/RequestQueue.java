package com.abc.thread.guarded_suspension;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 21:21
 * @project IntelliJ IDEA
 */
// LinkedList 实现方式
//public class RequestQueue {
//  private final Queue<Request> queue = new LinkedList<>();
//  public synchronized Request takeQueue() {
//    while(queue.peek() == null){
//      try {
//        this.wait();
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
//    return queue.remove();
//  }
//
//  // 加入队列
//  public synchronized void putRequest(Request request){
//    queue.offer(request);
//    notifyAll();
//  }
//}
public class RequestQueue{
  // LinkedBlockingQueue 是线程安全的阻塞队列
  private final BlockingQueue<Request> requestQueue = new LinkedBlockingDeque<>();
  public Request takeQueue(){
    Request request = null;
    try {
      request = requestQueue.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return request;
  }

  public void putQueue(Request request){
    requestQueue.offer(request);
  }
}
