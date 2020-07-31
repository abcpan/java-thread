package com.abc.thread.log;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/16 16:54
 */
public class TSLog {
  private PrintWriter writer = null;

  // init the writer
  public TSLog(String filename){
    try{
      writer = new PrintWriter(new FileWriter(filename));
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  // write content into file
  public void println(String s){
    writer.println(s);
  }
  // close log
  public void close(){
    writer.println("=== END OF LOG ===");
    writer.close();
  }
}
