package com.abc.thread.future;

import java.util.concurrent.TimeUnit;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/15 23:39
 * @project IntelliJ IDEA
 */
public class RealData implements Data {
  private final String content;
  public RealData(int count,char c){
    System.out.println("   making realData(" + count + ", " + c + ") BEGIN");
    char[] buffer = new char[count];
    for(int i = 0;i<count;i++){
      buffer[i] = c;
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    //
    System.out.println("   making RealData(" + count + ", " + c + ") END");
    this.content = new String(buffer);
  }
  @Override
  public String getContent() {
    return this.content;
  }
}
