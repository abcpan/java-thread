package com.abc.thread.cache;

import java.util.concurrent.*;

public class Memo<A,V> implements Computable<A, V> {
  // 缓存容器
  private final ConcurrentHashMap<A, Future<V>> cache = new ConcurrentHashMap<>();
  
  // 缓存执行方法
  private final Computable<A, V> c;
  
  public Memo(Computable<A,V> c) {
    this.c = c;
  }
  
  /**
   * 计算
   * @param arg
   * @return
   * @throws InterruptedException
   */
  @Override
  public V compute(final A arg) throws InterruptedException {
    while(true) {
      Future<V> future = cache.get(arg);
      if(future == null) {
        Callable<V>  eval = () -> c.compute(arg);
        FutureTask<V> futureTask = new FutureTask<>(eval);
        future = cache.putIfAbsent(arg, futureTask);
        if(future == null) {
          future = futureTask;
          futureTask.run();
        }
      }
      
      //
      try {
        return future.get();
      }catch (CancellationException | ExecutionException e) {
        cache.remove(arg,future);
      }
    }
  }
}
