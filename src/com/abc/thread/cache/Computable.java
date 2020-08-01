package com.abc.thread.cache;

/**
 * 计算接口
 * @param <A> 计算参数
 * @param <V> 计算结果
 */
public interface Computable<A,V> {
  V compute(A arg) throws InterruptedException;
}
