package com.abc.thread.Fight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/4 10:23
 */
public class FigthExample {
  private static List<String> fightCompanies = Arrays.asList("南方航空","北京航空","四川航空");
  public static void main(String[] args){
    List<String> searchs = search("上海","南京");
    System.out.println("==================================result======================");
    searchs.forEach(item-> System.out.println(item));
  }

  public static List<String> search(String origin,String destination){
    final List<String> resultList = new ArrayList<>();
    List<FigthQueryTask> tasks = fightCompanies.stream().map(c->createFightTask(c,origin,destination)).collect(Collectors.toList());
    //启动所有线程
    tasks.forEach(Thread::start);
    //分别调用每一个线程的join 方法，阻塞当前线程
    tasks.forEach(t->{
      try {
        t.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    //收集结果
    tasks.stream().map(FigthQueryTask::get).forEach(ret->resultList.addAll(ret));
    return resultList;
  }

  public static FigthQueryTask createFightTask(String fight,String origin,String dest){
    return new FigthQueryTask(fight,origin,dest);
  }
}
