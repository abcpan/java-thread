package com.abc.thread.classload;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 11:11
 */
public class BootstrapClassLoader {
  public static void main(String[] args){
    System.out.println("================>");
    // 根加载器是无法获取到引用的
    System.out.println(String.class.getClassLoader());
    System.out.println(System.getProperty("sun.boot.class.path"));
  }
}
