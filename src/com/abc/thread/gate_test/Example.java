package com.abc.thread.gate_test;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 15:14
 */
public class Example {
  public static void main(String[] args){
    Gate gate = new Gate();
    Thread t1 = new Passenger(gate,"Alice","Alaska");
    Thread t2 = new Passenger(gate,"Bobby","Brazil");
    Thread t3 = new Passenger(gate,"Chris","Canada");
    t1.start();
    t2.start();
    t3.start();
  }
}
