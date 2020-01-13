package com.abc.thread.threadsecurity;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 18:31
 */
public class EatNoodleThreadPair extends  Thread{

  private final String name;

  private final  TablewarePair tablewarePair;

  public EatNoodleThreadPair(String name,TablewarePair tablewarePair){
    this.name = name;
    this.tablewarePair = tablewarePair;
  }

  // 吃面条过程
  public void eat() {
    synchronized (tablewarePair){
      System.out.println(name + "take up " + tablewarePair.getLeftTool() + "(left)");
      System.out.println(name + "take up" + tablewarePair.getRightTool() + "(right)");
      System.out.println(name + "is eating now.");
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(name + "put down " + tablewarePair.getLeftTool() + "(right)");
      System.out.println(name + "put down" + tablewarePair.getRightTool() + "(left)");

    }

  }
  @Override
  public void run() {
    while(true){
      this.eat();
    }
  }
  public static void main(String[] args){
    Tableware fork = new Tableware("fork");
    Tableware knife = new Tableware("knife");
    TablewarePair tablewarePair = new TablewarePair(fork,knife);

    new EatNoodleThreadPair("小明",tablewarePair).start();
    new EatNoodleThreadPair("小花",tablewarePair).start();


  }
}
