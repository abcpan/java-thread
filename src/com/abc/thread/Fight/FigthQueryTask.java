package com.abc.thread.Fight;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/4 10:10
 */
public class FigthQueryTask extends Thread implements FightQuery {
  private final String origin;
  private final String destination;
  private final List<String> finghtList = new ArrayList<>();

  public FigthQueryTask(String airline,String origin,String destination) {
    super("[" + airline + "]");
    this.origin = origin;
    this.destination = destination;
  }



  @Override
  public List<String> get() {
    return this.finghtList;
  }

  @Override
  public void run() {
    // getName 为当前线程名称
    System.out.printf("%s-query from %s to %s\n",getName(),this.origin,this.destination);
    //线程随机值
    int randomValue = ThreadLocalRandom.current().nextInt(10);
    try {
      TimeUnit.SECONDS.sleep(randomValue);
      this.finghtList.add(getName() + "===>" + randomValue);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
