package com.abc.thread.threadobserver;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 15:37
 */
public interface TaskLifeCycle<T> {
  // 任务启动时会触发onStart方法
  default void onStart(Thread thread){};

  // 任务正在运行时会触发onRunning
  default void onRunning(Thread thread){};

  // 任务运行结束时会触发onFinished方法，其中result 时任务结束后的结果
  default void onEnd(Thread thread,T result){};

  // 任务报错时会触发onError 方法
  default void onError(Thread thread,Exception e){};
  // 生命周期啊接口空的实现
  class EmptyLifeCycle<T> implements TaskLifeCycle<T>{

    @Override
    public void onStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onEnd(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }
  }
}
