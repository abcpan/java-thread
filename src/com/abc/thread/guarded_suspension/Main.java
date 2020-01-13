package com.abc.thread.guarded_suspension;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 21:52
 * @project IntelliJ IDEA
 */
public class Main {
  public static void main(String[] args){
    RequestQueue requestQueueq = new RequestQueue();
    new ClientThread(requestQueueq,"Alice",3141592L).start();
    new ServerThread(requestQueueq,"Bobby",653897L).start();
  }
}
