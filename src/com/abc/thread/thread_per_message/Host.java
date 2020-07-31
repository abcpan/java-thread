package com.abc.thread.thread_per_message;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/15 14:40
 */
public class Host {
  private final Helper helper = new Helper();
  public void request(final int count ,final char c){
    System.out.println(" request ( " + count + ", " + c + ") BEGIN");
    new Thread(()->{
      try {
        helper.handle(count,c);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }).start();
    System.out.println(" request(" + count + ", " + c + ") END");
  }


}
