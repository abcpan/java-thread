package com.abc.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/15 23:28
 * @project IntelliJ IDEA
 */
public class FutureData extends FutureTask<RealData> implements Data {

  public FutureData(Callable<RealData> callable){
    super(callable);
  }

//  public synchronized void setRealData(RealData realData){
//    if(ready){
//      return;   // balk
//    }
//    this.realData = realData;
//    this.ready = true;
//    notifyAll();
//  }
//  @Override
//  public synchronized String getContent() {
//    while(!ready){
//      try{
//        wait();
//      }catch (Exception e){
//        e.printStackTrace();
//      }
//    }
//    return realData.getContent();
//  }
    @Override
  public synchronized String getContent() {
    String content = null;
    try{
      content = get().getContent();
    }catch (Exception e){
      e.printStackTrace();
    }
    return content;
  }
}
