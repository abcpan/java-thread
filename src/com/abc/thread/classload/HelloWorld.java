package com.abc.thread.classload;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 13:52
 */
public class HelloWorld {
  static {
    System.out.println("Hello World Class is Initialized");
  }
  public String welcome(){
    return "Hello world";
  }
  public static void main(String[] args){
    System.out.println("hello world===============>");
  }
}
