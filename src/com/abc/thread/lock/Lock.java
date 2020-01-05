package com.abc.thread.lock;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: Lock
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 11:12
 */
public interface Lock {
  void lock() throws InterruptedException;
  void lock(long mills) throws InterruptedException, TimeoutException;
  void unlock();
  List<Thread> getBlockedThreads();
}
