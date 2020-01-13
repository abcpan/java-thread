package com.abc.thread.balk;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/13 23:28
 * @project IntelliJ IDEA
 */
public class Data {
  private final String filename;
  private String content;
  private boolean changed;

  public Data(String filename, String content) {
    this.filename = filename;
    this.content = content;
    this.changed = true;
  }

  // 修改数据的内容
  public synchronized void change(String newContent){
    content = newContent;
    changed = true;
  }

  /**
   * if the content is changed,save the content to file
   * @throws IOException
   */
  public synchronized void save() throws IOException {
    if(!changed){
      return;
    }
    doSave();
    changed = false;
  }

  /**
   * save the actual content into file
   * @throws IOException
   */
  private void doSave() throws IOException {
    System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
    Writer writer = new FileWriter(filename);
    writer.write(content);
    writer.close();
  }
}
