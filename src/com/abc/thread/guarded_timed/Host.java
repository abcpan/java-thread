package com.abc.thread.guarded_timed;

import java.util.concurrent.TimeoutException;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 10:05
 */
public class Host {
  private final long timeout;
  private boolean ready = false;

  public Host(long timeout){
    this.timeout = timeout;

  }

  /**
   * change status
   * @param on
   */
  public synchronized void setExecutable(boolean on){
    this.ready = on;
    notifyAll();
  }
  /**
   * check ready status then execute
   * @throws TimeoutException
   * @throws InterruptedException
   */
  public synchronized void execute() throws TimeoutException, InterruptedException {
    long start = System.currentTimeMillis();  // startTime
    while(!ready){
      long now = System.currentTimeMillis();
      long rest = timeout - (now - start);
      if(rest < 0){
        throw new TimeoutException("now - start = " + (now - start) + " , timeout = " + timeout);
      }
      wait(rest);
    }
    doExecute();
  }

  /**
   * actual execute something
   */
  private void doExecute(){
    System.out.println(Thread.currentThread().getName() + " calls do Execute");
  }
}
