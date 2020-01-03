package com.abc.thread;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: ThreadPriority
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/3 23:08
 */
public class ThreadPriority {
  public static void main(String[] args){
    testThreadGroup();
  }
  public static void testThreadPriority(){
    Thread t1 = new Thread(()->{
      while(true){
        System.out.println("thread ===>t1 is running");
      }
    });
    Thread t2 = new Thread(()->{
      while(true){
        System.out.println("thead ===>t2 is running");
      }
    });
    t1.setPriority(8);
    t2.setPriority(3);
    t1.start();
    t2.start();
  }
  public static void testThreadGroup(){
    ThreadGroup group = new ThreadGroup("test");
    //线程组最大优先级为7
    group.setMaxPriority(7);
    Thread t2 = new Thread(group,()-> System.out.println(Thread.currentThread().getPriority()));
    // 线程最大优先级上限为线程组最大优先级
    t2.setPriority(10);
    t2.start();
  }
}
