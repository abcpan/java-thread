package com.abc.thread.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundHashSet<T> {
  private final Set<T> set;
  private final Semaphore semaphore;
  public BoundHashSet(int bound) {
    this.set = Collections.synchronizedSet(new HashSet<>());
    this.semaphore = new Semaphore(bound);
  }
  
  /**
   * 添加元素
   * @param o
   * @return
   * @throws InterruptedException
   */
  public boolean add(T o) throws InterruptedException {
    semaphore.acquire();
    boolean isAdded = false;
    try {
      isAdded = set.add(o);
      return isAdded;
    }finally {
      if(!isAdded){
        semaphore.release();
      }
    }
    
  }
  public boolean remove(Object o) {
    boolean isRemoved = set.remove(o);
    if(isRemoved) {
      semaphore.release();
    }
    return isRemoved;
  }
}
