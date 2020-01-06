package com.abc.thread.singleton;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 23:56
 * @project IntelliJ IDEA
 */
public final class SingletonHolder {
    private byte[] data = new byte[1024];
    private SingletonHolder(){}
    public static class Holder{
        private static SingletonHolder instance = new SingletonHolder();
    }
    public static SingletonHolder getInstance(){
        return Holder.instance;
    }
}
