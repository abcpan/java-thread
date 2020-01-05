package com.abc.thread.threadpool;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/5 23:39
 * @project IntelliJ IDEA
 */
public interface ThreadPool {
    //提交任务到队列
    void execute(Runnable runnable);

    // 关闭线程池
    void shutdown();

    // 获取线程池初始化大小
    int getInitSize();

    // 获取线程最大数量
    int getMaxSize();

    // 获取线程池核心线程数量
    int getCoreSize();

    //获取线程池中缓存任务队列的大小
    int getQueueSize();

    // 获取线程池中活跃线程数量
    int getActiveSize();

    // 查看线程池是否已经被shutdown
    boolean isShutdown();
}
