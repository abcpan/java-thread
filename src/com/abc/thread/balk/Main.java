package com.abc.thread.balk;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 23:43
 * @project IntelliJ IDEA
 */
public class Main {
  public static void main(String[] args){
    Data data = new Data("data.txt","(empty)");
    new ChangerThread("changeThread",data).start();
    new SaverThread("saveThread",data).start();
  }
}
