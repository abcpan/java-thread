package com.abc.thread.readwritelock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 11:15
 */
public class WriterThread extends Thread{
  private static final Random random = new Random();
  private final Data data;
  private final String filler;
  private int index = 0;
  public WriterThread(Data data, String filler){
    this.data = data;
    this.filler = filler;
  }
  @Override
  public void run() {
    try{
      while(true){
        char c = nextChar();
        data.write(c);
        TimeUnit.MILLISECONDS.sleep(random.nextInt(3000));
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  private char nextChar(){
    char c = filler.charAt(index);
    index ++;
    if(index >= filler.length()){
      index = 0;
    }
    return c;
  }
}
