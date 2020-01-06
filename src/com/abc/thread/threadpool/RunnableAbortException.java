package com.abc.thread.threadpool;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/6 10:18
 */
public class RunnableAbortException extends RuntimeException{
  public RunnableAbortException(String msg){
    super(msg);
  }
}
