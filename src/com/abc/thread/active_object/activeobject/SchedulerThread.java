package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:32
 * @project IntelliJ IDEA
 */
public class SchedulerThread extends Thread {
  private final ActivationQueue queue;
  public SchedulerThread(ActivationQueue queue){
    this.queue = queue;
  }

  public void invoke(MethodRequest request){
    queue.putRequest(request);
  }
  @Override
  public void run() {
    while(true){
      MethodRequest request = queue.takeRequest();
      request.execute();
    }
  }
}
