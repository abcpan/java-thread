package com.abc.thread.threadobserver;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 15:28
 */
public interface Observable<T> {
  // 任务生命周期的的枚举类型
  enum Cycle{
    STARTED,RUNNING,DONE,ERROR
  }
  // 获取当前任务的生命周期状态
  Cycle getCycle();

  // 定义启动线程的方法，主要作用是为了屏蔽Thread 的其他方法
  void start();

  // 定义线程的打断方法，作用域start 一致，也是为了屏幕Thread 的其他方法
  void interrupt();

  void notify(Cycle cycle,T result,Exception e);
}
