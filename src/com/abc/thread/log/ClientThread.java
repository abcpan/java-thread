package com.abc.thread.log;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 17:04
 */
public class ClientThread  extends  Thread{
  public ClientThread(String name){
    super(name);
  }

  @Override
  public void run() {
    System.out.println(getName() + " BEGIN===>");
    for(int i = 0; i < 10; i++){
      Log.println("i===>" + i);
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // close the writer
    Log.close();
    System.out.println(getName() + " END===>");
  }

}
