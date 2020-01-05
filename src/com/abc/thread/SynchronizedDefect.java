package com.abc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: SynchronizedDefect
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 10:50
 */
public class SynchronizedDefect {
  public synchronized void syncMethod(){

    try {
      for(int i = 0 ;i< 2000;i++){
        System.out.println(Thread.currentThread().getName() + "===> is running...");
        // 此方法不会释放锁
        TimeUnit.MILLISECONDS.sleep(1000);
        notify();
        wait();

      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    SynchronizedDefect synchronizedDefect = new SynchronizedDefect();
    Thread t1 = new Thread(synchronizedDefect::syncMethod,"method-1");
    t1.start();
    TimeUnit.MILLISECONDS.sleep(2);

    //执行t2
    Thread t2 = new Thread(synchronizedDefect::syncMethod,"method-2");
    t2.start();
  }
}
