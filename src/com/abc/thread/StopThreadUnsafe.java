package com.abc.thread;

import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: StopThreadUnsafe
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/4 20:30
 */
public class StopThreadUnsafe {
  public static User user = new User();
  public static class User{
    private String name;
    private int id;

    public User() {
      this.id = 0;
      this.name = "0";
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    @Override
    public String toString() {
      return "User{" +
          "name='" + name + '\'' +
          ", id=" + id +
          '}';
    }
  }

  /**
   *
   */
   static class ChangeObjectThread extends Thread{
    @Override
    public void run() {
     while(true){
       synchronized(user){
         int value = (int)(System.currentTimeMillis()/1000);
         user.setId(value);
         try{
           TimeUnit.MILLISECONDS.sleep(100);
         }catch (InterruptedException e){
           e.printStackTrace();
         }
         user.setName(String.valueOf(value));
       }
       Thread.yield();
     }
    }
  }
  /**
   *
   */
  static class ReadObjectThread extends Thread{
    @Override
    public void run() {
      while(true){
        synchronized(user){
          if(user.getId() != Integer.parseInt(user.getName())){
            System.out.println(user.toString());
          }
        }
        Thread.yield();
      }

    }
  }

  public static void main(String[] args) throws InterruptedException {
    new ReadObjectThread().start();
    while(true){
      Thread t = new ChangeObjectThread();
      t.start();
      TimeUnit.MILLISECONDS.sleep(150);
      t.stop();
    }
  }
}
