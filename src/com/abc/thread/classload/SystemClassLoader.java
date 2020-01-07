package com.abc.thread.classload;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 11:20
 */
public class SystemClassLoader {
  public static void main(String[] args){
    // 系统类加载器路径
    String sysLoaderPath = System.getProperty("java.class.path");
    System.out.println(sysLoaderPath);
  }
}
