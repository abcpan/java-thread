package com.abc.thread.threadContext;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 14:37
 */
public class MainThreadClassLoader {
  public static void main(String[] args){
    System.out.println(Thread.currentThread().getContextClassLoader());
  }
}
