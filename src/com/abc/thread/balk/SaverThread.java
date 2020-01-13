package com.abc.thread.balk;

import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 23:34
 * @project IntelliJ IDEA
 */
public class SaverThread extends Thread{
  private final Data data;
  public SaverThread(String name,Data data){
    super(name);
    this.data = data;
  }

  @Override
  public void run() {
   try{
     while(true){
       data.save(); // save the data
       TimeUnit.MILLISECONDS.sleep(1000);  // sleep 1 second
     }
   }catch (Exception e){

   }
  }
}
