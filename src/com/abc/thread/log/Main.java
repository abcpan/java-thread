package com.abc.thread.log;


import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.TimeUnit;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 16:48
 */
public class Main {
  public static void main(String [] args){
    new ClientThread("ZENGLINGAO").start();
    new ClientThread("JINXIN").start();
    new ClientThread("ZHULEYI").start();
    new ClientThread("YANCHANG").start();
}
}
