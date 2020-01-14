package com.abc.thread.gate_test;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/13 15:08
 */
public class Gate {
  private int count = 0;
  private String currentName = "UNKNOWN";
  private String currentAddress = "UNKNOWN";

  public Gate() {
  }
  public synchronized void  pass(String name,String address){
    this.count ++;
    this.currentName = name;
    this.currentAddress = address;
    this.check();
  }
  public void check(){
    if(this.currentAddress.charAt(0) != this.currentName.charAt(0)){
      System.out.println("***BROKEN***"+ this.currentName + "===" + this.currentAddress);
      return;
    }
    System.out.println(currentName + currentAddress + "is passing============>");
  }

  @Override
  public String toString() {
    return "Gate{" +
        "count=" + count +
        ", currentName='" + currentName + '\'' +
        ", currentAddress='" + currentAddress + '\'' +
        '}';
  }
}
