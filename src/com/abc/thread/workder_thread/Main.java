package com.abc.thread.workder_thread;


/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 17:15
 */
public class Main {
  public static void main(String[] args){
    Channel channel = new Channel(5); // 工人线程数量
    channel.startWorkers();
    new ClientThread("Alice",channel).start();
    new ClientThread("Bobby",channel).start();
    new ClientThread("Chris",channel).start();
  }
}
