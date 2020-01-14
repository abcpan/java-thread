package com.abc.thread.gate_test;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 15:12
 */
public class Passenger extends Thread{
  private final String name;
  private final String address;
  private final Gate gate;

  public Passenger(Gate gate,String name, String address) {
    this.name = name;
    this.address = address;
    this.gate = gate;
  }

  @Override
  public void run() {
    while(true){
      gate.pass(this.name,this.address);
    }
  }
}
