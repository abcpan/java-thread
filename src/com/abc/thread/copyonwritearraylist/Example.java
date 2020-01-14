package com.abc.thread.copyonwritearraylist;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 18:12
 */
public class Example {
  public final static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
  public static void main(String[] args){
    // 写线程
    Thread writeThread = new Thread(()->{
      for(int i = 0;i<1000;i++){

        try {
          list.add(i);
          TimeUnit.SECONDS.sleep(1);
          list.remove(0);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

      }
    });
    // 读线程
    Thread readThread = new Thread(()->{
      for(int i :list){
        System.out.println("列表中===>" + i);
      }

    });
    writeThread.start();
    readThread.start();
  }

}
