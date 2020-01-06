package com.abc.thread.singleton;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 23:49
 * @project IntelliJ IDEA
 */

/**
 * 双重校验锁
 */
public final class SingletonVolatile {
    private byte[] data = new byte[1024];
    private SingletonVolatile(){}
    private static volatile SingletonVolatile instance = null;
    public SingletonVolatile getInstance(){
        if(instance ==null){
            synchronized (SingletonVolatile.class){
                if(instance ==null){
                    instance = new SingletonVolatile();
                }
            }

        }
        return instance;
    }
}
