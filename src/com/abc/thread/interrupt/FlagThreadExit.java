package com.abc.thread.interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: FlagThreadExit
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 16:13
 */
public class FlagThreadExit {
  static class MyTask extends Thread{
    private volatile boolean closed = false;
    @Override
    public void run() {
      System.out.println("i will start work");
      while (!closed && !isInterrupted()){
        System.out.println("i am working====>");
      }
      System.out.println("i am will be exiting");
    }

    public void close(){
      this.closed = true;
      this.interrupt();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    MyTask myTask = new MyTask();
    myTask.start();
    TimeUnit.MINUTES.sleep(1);
    System.out.println("System will be shutdown");
    myTask.close();
  }
}
