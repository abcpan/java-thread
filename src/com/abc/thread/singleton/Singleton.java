package com.abc.thread.singleton;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 23:37
 * @project IntelliJ IDEA
 */

/**
 * 饿汉式
 * final 不允许被继承
 */
public final class Singleton {
    // 实例变量
    private byte[] data = new byte[1024];

    // 定义实例变量的时候直接初始化
    private static Singleton instance = new Singleton();

    // 私有构造函数 不允许被外部new
    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}
