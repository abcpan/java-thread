package com.abc.thread.deadlock;

import java.util.HashMap;
import java.util.stream.IntStream;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: HashMapDeadLock
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 22:36
 */
public class HashMapDeadLock {
  private final HashMap<String,String> map = new HashMap<>();
  public void add(String key,String value){
    this.map.put(key,value);
  }
  public static void main(String[] args){
    final HashMapDeadLock hashMapDeadLock = new HashMapDeadLock();
    for(int x=0;x<2;x++){
      new Thread(()->{
        for(int i = 1;i<Integer.MAX_VALUE;i++){
          hashMapDeadLock.add(String.valueOf(i),String.valueOf(i));
        }
      }).start();
    }
  }
}
