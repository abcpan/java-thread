package com.abc.thread;

import java.util.stream.IntStream;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/3 17:45
 */

public class TicketWindow implements Runnable {
  //柜台名称
  private  int index = 1;
  //最大销售数量
  private static final int max = 50;
  @Override
  public void run(){
    synchronized(TicketWindow.class){
      while(index <=max){
        System.out.println(Thread.currentThread()+ "当前的号为" + (this.index++));
        try{
          Thread.sleep(100L);
        }catch (InterruptedException e){
          e.printStackTrace();
        }
      }

    }
  }

  public static void main( String[] args){
    final TicketWindow task = new TicketWindow();
    Thread t1 = new Thread(task,"一号窗口");
    Thread t2 = new Thread(task,"二号窗口");
    Thread t3 = new Thread(task,"三号窗口");
    Thread t4 = new Thread(task,"四号窗口");
    t1.start();
    t2.start();
    t3.start();
    t4.start();
//    IntStream.rangeClosed(1,5).boxed().map(i->new Thread(()->{
//      System.out.println(Thread.currentThread().getName());
//    })).forEach(Thread::start);
 }
}
