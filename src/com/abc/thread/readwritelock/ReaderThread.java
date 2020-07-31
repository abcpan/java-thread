package com.abc.thread.readwritelock;


/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 11:35
 */
public class ReaderThread extends Thread {
  private final Data data;
  public ReaderThread(Data data){
    this.data = data;
  }

  @Override
  public void run() {
   try{
     while(true){
       char[] readBuf = data.read();
       System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(readBuf));
     }
   }catch (Exception e){
     e.printStackTrace();
   }
  }
}
