package com.abc.thread.active_object;

import com.abc.thread.active_object.activeobject.Result;

import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:13
 * @project IntelliJ IDEA
 */
public class MakerClientThread extends Thread {
  private final ActiveObject activeObject;
  private final char fillchar;

  public MakerClientThread(String name,ActiveObject activeObject){
    super(name);
    this.activeObject = activeObject;
    this.fillchar = name.charAt(0);
  }

  @Override
  public void run() {
    try{
      for(int i = 0; true; i++){
        // the call having return value
        Result<String> result = activeObject.makeString(i,fillchar);
        TimeUnit.MILLISECONDS.sleep(10);
        String value = result.getResultValue();
        System.out.println(getName() + ": value = " + value);
      }
    }catch (Exception e){

    }
  }
}