package com.abc.thread.active_object;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:12
 * @project IntelliJ IDEA
 */
public class Main {
  public static void main(String[] args){
    ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
    new MakerClientThread("Alice",activeObject).start();
    new MakerClientThread("Bobby",activeObject).start();
    new DisplayClientThread("Chris",activeObject).start();
  }
}
