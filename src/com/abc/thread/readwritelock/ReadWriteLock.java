package com.abc.thread.readwritelock;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 12:25
 */
public class ReadWriteLock {
  private int readingReaders = 0;
  private int waitingWriters = 0;
  private int writingWriters = 0;
  private boolean preferWriter = true;

  public synchronized void readLock() throws InterruptedException {
    // 如果正在写入的线程存在 或者 偏向写锁 且有等待的写线程
    while(writingWriters > 0 || (preferWriter && waitingWriters> 0)){
      wait();
    }
    readingReaders++;
  }

  public synchronized void readUnLock(){
    readingReaders --;
    preferWriter = true;  // prefer to get write lock
    notifyAll();
  }

  /**
   * acquire write lock
   */
  public synchronized void writeLock(){
    waitingWriters++;
    try{
      while(readingReaders > 0 || writingWriters> 0){
        wait();
      }
    }catch (Exception e){
      e.printStackTrace();
    }finally {
      waitingWriters --;
    }
    writingWriters ++;
  }

  /**
   * release write lock
   */
  public synchronized  void writeUnLock(){
    writingWriters --;
    preferWriter = false;
    notifyAll();
  }
}
