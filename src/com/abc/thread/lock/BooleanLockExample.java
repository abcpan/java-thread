package com.abc.thread.lock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: BooleanLockExample
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 11:49
 */
public class BooleanLockExample {
  private final Lock lock = new BooleanLock();

  public void syncMethod(){
    //枷锁
    try {
      lock.lock();
      int randomInt = ThreadLocalRandom.current().nextInt(10);
      System.out.println(Thread.currentThread() + " get the lock.");
      TimeUnit.SECONDS.sleep(randomInt);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  /**
   * 主程序测试
   *
   * @param args
   */
  public static void main(String[] args) {
    BooleanLockExample booleanLockExample = new BooleanLockExample();
    // 定义一个线程并启动
    IntStream.rangeClosed(0, 10).mapToObj(i -> new Thread(booleanLockExample::syncMethod)).forEach(thread -> thread.start());
  }
}
