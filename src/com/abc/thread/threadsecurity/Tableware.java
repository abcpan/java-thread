package com.abc.thread.threadsecurity;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 18:04
 */
public class Tableware {
  // 餐具名称
  private final String toolName;

  public Tableware(String toolName){
    this.toolName = toolName;
  }
  @Override
  public String toString(){
    return "Tool:==>" + toolName;
  }
}
