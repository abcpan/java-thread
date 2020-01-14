package com.abc.thread.producer_consumer;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/14 10:47
 */
public class Main {
  public static void main(String[] args){
    Table table = new Table(20);
    new MakerThread("makerThread-1",table,31415).start();
    new MakerThread("makerThread-2",table,92653).start();
    new EaterThread("eaterThread-1",table,58979).start();
    new EaterThread("eaterThread-2",table,38327).start();
  }
}
