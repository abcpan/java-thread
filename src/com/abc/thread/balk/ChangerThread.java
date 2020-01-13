package com.abc.thread.balk;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 23:38
 * @project IntelliJ IDEA
 */
public class ChangerThread extends Thread{
  private final Data data;
  private final Random random = new Random();
  public ChangerThread(String name,Data data){
    super(name);
    this.data = data;
  }
  @Override
  public void run() {
    try{
      for(int i = 0;true;i++){
        data.change("NO." + i);
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        data.save();
      }
    }catch (IOException | InterruptedException e){
      e.printStackTrace();
    }
  }
}
