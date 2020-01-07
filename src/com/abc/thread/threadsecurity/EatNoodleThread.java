package com.abc.thread.threadsecurity;

import java.time.chrono.ThaiBuddhistChronology;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 18:07
 */
public class EatNoodleThread extends Thread {

  private final String name;

  // 左手餐具
  private final Tableware leftTool;

  // 右手餐具
  private final Tableware rightTool;

  public EatNoodleThread(String name,Tableware leftTool,Tableware rightTool){
    this.name = name;
    this.leftTool = leftTool;
    this.rightTool = rightTool;
  }

  // 吃面条过程
  public void eat(){
    synchronized (leftTool){
      System.out.println(name + "take up " + leftTool + "(left)");
      synchronized (rightTool){
        System.out.println(name + "take up" + rightTool + "(right)");
        System.out.println(name + "is eating now.");
        System.out.println(name + "put down " + rightTool + "(right)");
      }
      System.out.println(name + "put down" + leftTool + "(left)");
    }

  }
  @Override
  public void run() {
    while(true){
      this.eat();
    }
  }
  public static void main(String[] args){
     //交叉锁
    Tableware fork = new Tableware("fork");
    Tableware knife = new Tableware("knife");
    new EatNoodleThread("小明",fork,knife).start();
    new EatNoodleThread("小花",knife,fork).start();


  }
}
