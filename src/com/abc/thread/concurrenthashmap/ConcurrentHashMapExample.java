package com.abc.thread.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/8 17:50
 */
public class ConcurrentHashMapExample {
  public static ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap<>();
  public static void main(String[] args){
    // 修改线程
    new Thread(()->{
      for(int i = 1;i<=20;i++){
        map.put(i,i);
      }
    }).start();
    // 读取线程
    new Thread(()->{
      for(int i = 0;i<20;i++){
        Integer result = map.getOrDefault(i,0);
        System.out.println("===>"+result);
        System.out.println("============<<<<<<" + map.size());
      }
    }).start();
    System.out.println(map.get(5));
  }
}
