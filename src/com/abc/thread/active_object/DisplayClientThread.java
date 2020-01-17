package com.abc.thread.active_object;

import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:17
 * @project IntelliJ IDEA
 */
public class DisplayClientThread extends Thread {
  private final ActiveObject activeObjectImpl;
  public DisplayClientThread(String name,ActiveObject activeObjectImpl){
    super(name);
    this.activeObjectImpl = activeObjectImpl;
  }
  @Override
  public void run() {
    try{
      for(int i = 0; true; i++){
        String string = getName() + " " + i;
        activeObjectImpl.displayString(string);
        TimeUnit.MILLISECONDS.sleep(200);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }
}
