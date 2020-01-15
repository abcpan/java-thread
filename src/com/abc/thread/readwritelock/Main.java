package com.abc.thread.readwritelock;


/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 11:00
 */
public class Main {
  public static void main(String[] args){
    Data data = new Data(10);
    new ReaderThread(data).start();
    new ReaderThread(data).start();
    new ReaderThread(data).start();
    new ReaderThread(data).start();
    new WriterThread(data,"ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
    new WriterThread(data,"abcdefghijklmnopqrstuvwxyz").start();
  }
}
