package com.abc.thread.active_object.activeobject;

import com.abc.thread.active_object.ActiveObject;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:30
 * @project IntelliJ IDEA
 */
public class Servant implements ActiveObject {
  @Override
  public Result<String> makeString(int count, char fillchar) {
    char[] buffer = new char[count];
     for(int i = 0;i<count; i++){
       buffer[i] = fillchar;
       try {
         TimeUnit.MILLISECONDS.sleep(100);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
     }
     return new RealResult<>(String.valueOf(buffer));
  }

  @Override
  public void displayString(String value) {
    System.out.println("displayString: " + value);
    try {
      TimeUnit.MILLISECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
