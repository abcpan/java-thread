package com.abc.thread.threadsecurity;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 18:28
 */
public class TablewarePair {
  private final Tableware leftTool;
  private final Tableware rightTool;

  public TablewarePair(Tableware leftTool, Tableware rightTool) {
    this.leftTool = leftTool;
    this.rightTool = rightTool;
  }

  public Tableware getLeftTool() {
    return leftTool;
  }

  public Tableware getRightTool() {
    return rightTool;
  }
}
