package com.abc.thread.future;

import java.util.concurrent.Callable;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/15 23:26
 * @project IntelliJ IDEA
 */
public class Host {
  public Data request(final int count,final char c){
    System.out.println("  request(" + count + ", " + ") BEGIN===>");

    // create FutureData instance
    final FutureData future = new FutureData(()->new RealData(count,c));
    new Thread(future).start();

    System.out.println("  request (" + count + ", " + c + ") END");

    // return the futureData'instance
    return future;
  }
}
