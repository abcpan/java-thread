package com.abc.thread.lock;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: BooleanLock
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 11:14
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

/**
 * lock 的boolean 实现,通过控制一个boolean变量的开关决定是否允许当前的线程获取该锁
 */
public class BooleanLock implements Lock{
  private Thread currentThread;
  // false 代表当前该锁没有被任何线程获得 或者已经被释放
  private boolean locked = false;
  private final List<Thread> blockedList = new ArrayList<>();

  @Override
  public void lock() throws InterruptedException {
    synchronized (this){
      while(locked){
        //如果阻塞线程中没有包含当前线程
        if(!blockedList.contains(Thread.currentThread())){
          blockedList.add(Thread.currentThread());
        }
        this.wait();
      }
      // 如果获得锁 就将其从阻塞列表中删除
      blockedList.remove(Thread.currentThread());
      this.locked = true;
      this.currentThread = Thread.currentThread();
    }
  }

  @Override
  public void lock(long mills) throws InterruptedException, TimeoutException {
    synchronized (this){
      if(mills <= 0){
        throw new IllegalAccessError("args is illegal");
      }else{
        long remainMillis = mills;
        long endMillis = System.currentTimeMillis() + remainMillis;
        // 不断添加删除
        while(locked){
          if(remainMillis <=0){
            throw new TimeoutException("can not get the lock during " + mills);
          }
          //如果阻塞线程中没有包含当前线程
          if(!blockedList.contains(Thread.currentThread())){
            blockedList.add(Thread.currentThread());
          }
          this.wait(remainMillis);
          remainMillis = endMillis - System.currentTimeMillis();
        }
          // 如果获得锁 就将其从阻塞列表中删除
          blockedList.remove(Thread.currentThread());
          this.locked = true;
          this.currentThread = Thread.currentThread();
      }
    }
  }

  @Override
  public void unlock() {
    synchronized (this){
      if(Thread.currentThread() == this.currentThread){
        this.locked = false;
        Optional.of(Thread.currentThread() + "release the lock").ifPresent(System.out::println);
        this.notifyAll();
      }
    }
  }

  @Override
  public List<Thread> getBlockedThreads() {
   return Collections.unmodifiableList(this.blockedList);
  }
}
