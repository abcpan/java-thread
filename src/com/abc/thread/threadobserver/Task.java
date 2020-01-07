package com.abc.thread.threadobserver;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 15:46
 */
@FunctionalInterface
public interface Task<T> {
  // 任务执行接口 该接口允许有返回值
  T call();
}
