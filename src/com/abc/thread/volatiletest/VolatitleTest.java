package com.abc.thread.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 17:45
 */
public class VolatitleTest {
  final static int MAX = 10;
  //初始化值
  static volatile int initValue = 0;

  public static void main(String[] args){
    //启动一个Reader 线程 如果localValue != initValue 则输出initValue;
    new Thread(()->{
      int localValue = initValue;
      while(localValue < MAX){
        if(initValue != localValue){
          System.out.println("now the initValue ===>" + initValue);
          //对localValue 进行重新赋值
          localValue = initValue;
        }
      }
    },"reader-thread==========>").start();

    // 启动一个写的线程修改initValue ,当localValue >=5 退出生命周期
    new Thread(()->{
      int localValue = initValue;
      while(localValue< MAX){
        System.out.printf("The initValue will be change to [%d]\n",++localValue);
        initValue = localValue;
        try {
          TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    },"update-thread").start();
  }

}
