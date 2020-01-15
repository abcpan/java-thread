package com.abc.thread.workder_thread;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 17:38
 */
public class WorkerThread extends Thread {
  private final Channel channel;
  public WorkerThread(String name, Channel channel){
    super(name);
    this.channel = channel;
  }

  @Override
  public void run() {
    while(true){
      Request request = channel.takeRequest();
      request.execute();
    }
  }
}
