package com.abc.thread.classinitialize;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 11:07
 */
public class ClassInit {
  // 静态代码块仅仅只会被执行一次
  static {
    System.out.println("the classinit static code block will be invoke");
    try {
      TimeUnit.SECONDS.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args){
    IntStream.rangeClosed(0,5).forEach(i->new Thread(ClassInit::new).start());
  }
}
