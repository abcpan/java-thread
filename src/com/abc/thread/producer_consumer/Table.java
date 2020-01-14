package com.abc.thread.producer_consumer;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 11:00
 */

/**
 * Channel(通道）
 */
public class Table {
  private final String[] buffer;
  private int tail; // the position to put next time
  private int head; // the position to take next time
  private int count;  // the count of the cakes

  public Table( int count) {
    this.buffer = new String[count];
    this.count = 0;
    this.head = 0;
    this.tail = 0;
  }

  /**
   * put the cake
   * @param cake
   * @throws InterruptedException
   */
  public synchronized  void put(String cake) throws InterruptedException {
    System.out.println(Thread.currentThread().getName() + " puts " + cake);
    while(count >= buffer.length){
      wait();
    }
    buffer[tail] = cake;
    tail = (tail + 1) % buffer.length;
    count ++;
    notifyAll();
  }

  /**
   * take the cake
   * @return
   * @throws InterruptedException
   */
  public synchronized String take() throws InterruptedException {
    while(count <= 0){
      wait();
    }
    String cake = buffer[head];
    head = (head+ 1) % buffer.length;
    count--;
    notifyAll();
    System.out.println(Thread.currentThread().getName() + " takes " + cake);
    return cake;
  }
}
