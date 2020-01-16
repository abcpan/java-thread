package com.abc.thread.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 16:39
 */
public class Log {
  private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();
  /**
   * write log
   *
   * @param s
   */
  public static void println(String s) {
    getTSLog().println(s);
  }

  /**
   * get TSLog of the special thread
   * @return
   */
  private static TSLog getTSLog(){
    TSLog tsLog = tsLogCollection.get();
    // if currentThread is first class this method,generate a TSLog and register it
    if(tsLog == null){
      tsLog = new TSLog(Thread.currentThread().getName() + "-log.text");
      tsLogCollection.set(tsLog);
    }
    return tsLog;
  }

  public static void close(){
    getTSLog().close();
  }
}
