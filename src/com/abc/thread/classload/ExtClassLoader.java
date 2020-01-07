package com.abc.thread.classload;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 11:16
 */
public class ExtClassLoader {
  public static void main(String[] args){
    // 拓展类加载器加载资源的路由
    System.out.println(System.getProperty("java.ext.dirs"));
    // 普通类加载器
    ClassLoader loader = BootstrapClassLoader.class.getClassLoader();
    System.out.println(loader);
  }
}
