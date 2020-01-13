package com.abc.thread.guarded_suspension;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 21:25
 * @project IntelliJ IDEA
 */
public class ClientThread extends Thread {
  private final Random random;
  private final RequestQueue requestQueue;
  public ClientThread(RequestQueue requestQueue,String name,long seed){
    super(name);
    this.requestQueue = requestQueue;
    this.random = new Random(seed);
  }
  @Override
  public void run() {
    for(int i = 1;i<=10000; i++){
      Request request = new Request("No." + i);
      System.out.println(Thread.currentThread().getName() + " request " + request);
      requestQueue.putQueue(request);
      try {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
