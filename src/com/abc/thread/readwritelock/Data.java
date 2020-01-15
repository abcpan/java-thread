package com.abc.thread.readwritelock;


import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 11:06
 */
public class Data {
  private final char[] buffer;
  private final ReadWriteLock lock = new ReadWriteLock();
  public Data(int size){
    this.buffer = new char[size];
    for(int i = 0;i< buffer.length;i++){
      buffer[i] = '*';
    }
  }
  public char[] read() throws InterruptedException {
    lock.readLock();
    try{
      return doRead();
    }finally {
      lock.readUnLock();
    }
  }

  /**
   * read content in reality
   * @return
   */
  private char[] doRead(){
    char[] newBuf = new char[buffer.length];
    for(int i = 0;i<buffer.length; i++){
      newBuf[i] = buffer[i];
    }
    slowly();
    return newBuf;
  }

  public void write(char c){
    lock.writeLock();
    try{
      doWrite(c);
    }finally {
      lock.writeUnLock();
    }
  }

  /**
   * write content in reality
   * @param c
   */
  private void doWrite(char c){
    for(int i = 0; i<buffer.length; i++){
      buffer[i] = c;
      slowly();
    }
  }

  private void slowly(){
    try {
      TimeUnit.MILLISECONDS.sleep(50);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
