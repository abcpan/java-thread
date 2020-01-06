package com.abc.thread.threadpool;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 10:09
 */
@FunctionalInterface
public interface DenyPolicy {
  void reject(Runnable runnable,ThreadPool threadPool);

  /**
   * 该拒绝策略会直接将任务丢弃
   */
  class DiscardDenyPolicy implements DenyPolicy{

    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
      // do nothing
    }
  }

  /**
   * 该拒绝策略会直接将任务抛出异常
   */
  class AbortDenyPolicy implements DenyPolicy{
    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
      throw new RunnableAbortException("this runnable ==>" + runnable + "will be abort");
    }
  }

  class RunnerDenyPolicy implements DenyPolicy{

    @Override
    public void reject(Runnable runnable, ThreadPool threadPool) {
      if(!threadPool.isShutdown()){
        runnable.run();
      }
    }
  }

}
