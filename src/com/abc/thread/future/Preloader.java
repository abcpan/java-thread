package com.abc.thread.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Preloader {
  private final FutureTask<String>  futureTask = new FutureTask(()-> {
    TimeUnit.MILLISECONDS.sleep(200);
    return "超级玛丽";
  });
  private final Thread thread = new Thread(this.futureTask);
  public void start () {
    thread.start();
    System.out.println("已经启动进行数据获取");
  }
  public String getResult() throws ExecutionException, InterruptedException {
    String result = futureTask.get();
    System.out.println(String.format("数据已经获取到%s", result));
    return result;
  }
  
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    Preloader preloader = new Preloader();
    // 首先启动
    preloader.start();
    // 先睡
    TimeUnit.SECONDS.sleep(2);
    String result = preloader.getResult();
    System.out.println(result);
  }
}
