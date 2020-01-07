package com.abc.thread.threadobserver;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 15:33
 */
public class Test {
  public static void main(String[] args){
    ObservableThread observableThread = new ObservableThread(()->{return "helloworld";},new Callback());
    observableThread.start();
  }
  static class Callback<T> implements TaskLifeCycle<T>{
    @Override
    public void onEnd(Thread thread, T result) {
      System.out.println(result);
      System.out.println(thread.getName());
    }
  }
}
