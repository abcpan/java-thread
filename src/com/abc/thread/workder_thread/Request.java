package com.abc.thread.workder_thread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 17:20
 */
public class Request {
  private final String name;
  private final int number;
  private final static Random random = new Random();
  public Request(String name,int number){
    this.name = name;
    this.number = number;
  }

  public void execute(){
    System.out.println(Thread.currentThread().getName() + " execute " + this);
    try{
      TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
    }catch (Exception e){

    }
  }

  public String toString(){
    return "[ Request from " + name + " NO." + number + " ]";
  }
}
