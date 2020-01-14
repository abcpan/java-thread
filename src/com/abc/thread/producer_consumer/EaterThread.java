package com.abc.thread.producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 10:57
 */
public class EaterThread extends Thread {
  private final Random random;
  private final Table table;
  public EaterThread(String name,Table table,long seed){
    super(name);
    this.table = table;
    this.random = new Random(seed);
  }

  @Override
  public void run() {
    try{
      while(true){
        String cake = table.take();
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }
}
