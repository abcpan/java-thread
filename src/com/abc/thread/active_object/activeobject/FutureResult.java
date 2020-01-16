package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:26
 * @project IntelliJ IDEA
 */
 class FutureResult<T> extends Result<T> {
   private Result<T> result;
   private boolean ready = false;
   public synchronized void setResult(Result<T> result){
     this.result = result;
     this.ready = true;
     notifyAll();
   }

  @Override
  public synchronized T getResultValue() {
    while(!ready){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return result.getResultValue();
  }
}
