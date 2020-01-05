package com.abc.thread.threadpool;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 1:36
 * @project IntelliJ IDEA
 */
@FunctionalInterface
public interface ThreadFactory {
    // 创建线程
    Thread createThread(Runnable runnable);
}
