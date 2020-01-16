package com.abc.thread.two_phase;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 9:51
 */
public class CountupThread extends Thread {
  // count
  private long counter = 0;

  // be true when emit the terminated request
  private volatile boolean shutdownRequested = false;

  // terminate the request
  public void shutdownRequest(){
    this.shutdownRequested = true;
    interrupt();
  }

  // check whether emit the request
  public boolean isShutdownRequested(){
    return this.shutdownRequested;
  }

  /**
   * the thread body
   */
  @Override
  public void run() {
    try{
      // if not emit shutdown signal
      while(!isShutdownRequested()){
        doWork();
      }
    }catch (Exception e){

    }finally {
      doShutdown();
    }
  }

  /**
   * work in reality
   * @throws InterruptedException
   */
  private void doWork() throws InterruptedException {
    counter++;
    System.out.println("dowWork: counter"  + counter);
    TimeUnit.MILLISECONDS.sleep(500);
  }

  /**
   * shutdown
   */
  private void doShutdown(){
    System.out.println(" dowShutdown : counter = " + counter);
  }
}
