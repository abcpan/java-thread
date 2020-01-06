package com.abc.thread;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 17:08
 */
public class ClassLoaderTest {
  public static void main(String[] args){
    System.out.println("String.class loader is===>"+ String.class.getClassLoader());
    System.out.println("root classLoader is " + System.getProperty("sun.boot.class.path"));
  }
}
