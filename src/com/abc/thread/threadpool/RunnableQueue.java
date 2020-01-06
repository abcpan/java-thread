package com.abc.thread.threadpool;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/6 1:12
 * @project IntelliJ IDEA
 */

/**
 * 任务队列 主要用于缓存提交到线程池红的任务
 */
public interface RunnableQueue {
    // 当有新的任务进来时首先会offer 到队列中
    void offer(Runnable runnable);

    // 工作线程通过take 方法获取Runnable
    Runnable take() throws InterruptedException;

    // 获取任务队列中的任务数量
    int size();
}
