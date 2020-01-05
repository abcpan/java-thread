package com.abc.thread.hook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-thread
 * @ClassName: PreventDuplicated
 * @Description:
 * @Author: abcpan
 * @Date: 2020/1/5 19:16
 */
public class PreventDuplicated {
  private final static String LOCK_PATH = "/home/wangwenjun/locks/";
  private final static String LOCK_FILE = ".lock";
  private final static String PERMISSIONS = "rw-------";
  public static void main(String [] args){
    // 注入Hook 线程 在线程退出时删除lock文件
    Runtime.getRuntime().addShutdownHook(new Thread(()->{
      System.out.println("The program received kill signal...");
      getLockFile().toFile().delete();
      // 检查是否存在.lock文件
      try {
        checkRunning();
      } catch (IOException e) {
        e.printStackTrace();
      }
      //简单模拟程序正在运行
      for(;;){
        try {
          TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }));
  }

  private static void checkRunning() throws IOException {
    Path path = getLockFile();
    if(path.toFile().exists()){
      throw new RuntimeException("the program is already runing");
    }
    Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSIONS);
    Files.createFile(path,PosixFilePermissions.asFileAttribute(perms));
  }
  private static Path getLockFile(){
    return Paths.get(LOCK_PATH,LOCK_FILE);
  }
}
