package com.abc.thread.guarded_suspension;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 21:18
 * @project IntelliJ IDEA
 */
public class Request {
  private final String name;

  public Request(String name) {
    this.name = name;
  }
  public String getName(){
    return this.name;
  }
  public String toString(){
    return "{Request" + this.name + "]";
  }
}
