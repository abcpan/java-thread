package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:18
 * @project IntelliJ IDEA
 */
abstract class MethodRequest<T> {
  protected final Servant servant;
  protected final FutureResult<T> future;
  protected MethodRequest(Servant servant,FutureResult<T> future){
    this.servant = servant;
    this.future = future;
  }

  public abstract void execute();
}
