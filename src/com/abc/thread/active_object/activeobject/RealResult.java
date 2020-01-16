package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:29
 * @project IntelliJ IDEA
 */
 class RealResult<T> extends Result<T> {
  private final T resultValue;
  public RealResult(T resultValue){
    this.resultValue = resultValue;
  }

  @Override
  public T getResultValue() {
    return resultValue;
  }
}
