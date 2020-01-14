package com.abc.thread.producer_consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 10:50
 */
public class MakerThread extends Thread{
  private final Random random;
  private final Table table;
  private static int id = 0;  // cake's number(all maker will use it)
  public MakerThread(String name,Table table,long seed){
    super(name);
    this.table = table;
    this.random = new Random(seed);
  }

  /**
   * produce the cake
   */
  @Override
  public void run(){
    try{
      while(true){
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));  // simulate the real make cake
        String cake = "{Cake No." + nextId() + " by " + getName() + "]";
        table.put(cake);
      }
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  /**
   * generate the id
   * @return
   */
  private static synchronized  int nextId(){
    return id ++;
  }
}
