package com.abc.thread.threadobserver;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 15:49
 */
public class ObservableThread<T> extends Thread implements Observable<T> {
  private final TaskLifeCycle<T> lifeCycle;
  private final Task<T> task;
  private Cycle cycle;

  // 指定Task 的实现 默认情况下使用EmptyLifeCycle
  public ObservableThread(Task<T> task){
    this(task,new TaskLifeCycle.EmptyLifeCycle<T>());
  }
  //
  public ObservableThread(Task<T> task,TaskLifeCycle<T> lifecycle){
    super();
    if(task == null){
      throw new IllegalArgumentException("The task is required");
    }
    this.lifeCycle = lifecycle;
    this.task = task;
  }
  // 实现获取生命周期的方法
  @Override
  public Cycle getCycle() {
    return this.cycle;
  }
  // 通知观察者
  @Override
  public void notify(Cycle cycle, T result, Exception e) {
    this.cycle = cycle;
    if(lifeCycle == null){
      return;
    }
    // 响应 某个事件可能会出现异常 必须进行捕获 确保任务继续进行
    try{
      switch (cycle){
        case STARTED:
          this.lifeCycle.onStart(currentThread());
          break;
        case RUNNING:
          this.lifeCycle.onRunning(currentThread());
          break;
        case DONE:
          this.lifeCycle.onEnd(currentThread(),result);
          break;
        case ERROR:
          this.lifeCycle.onError(currentThread(),e);
          break;
      }
    }catch (Exception ex){
      if(cycle == Cycle.ERROR){
        throw ex;
      }
    }
  }

  @Override
  public final void run() {
    this.notify(Cycle.STARTED,null,null);
    try{
      this.notify(Cycle.RUNNING,null,null);
      T result = this.task.call();
      this.notify(Cycle.DONE,result,null);
    }catch (Exception ex){
      this.notify(Cycle.ERROR,null,ex);
    }

  }
}
