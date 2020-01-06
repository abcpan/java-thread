package com.abc.thread.singleton;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 23:44
 * @project IntelliJ IDEA
 */

/**
 * 懒汉式
 */
public final class SingletonLazy {
    private byte[] data = new byte[1024];
    // 私有构造函数 不允许被外部new
    private SingletonLazy(){}
    private static SingletonLazy instance = null;
    public static synchronized SingletonLazy getInstance(){
        if(null == instance){
            instance = new SingletonLazy();
        }
        return instance;
    }
}
