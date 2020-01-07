package com.abc.thread.threadsecurity;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 16:48
 */
public class FightSecurity {
  //
  private int count = 0;
  // 登机牌
  private String boardingPass = "null";
  // 身份证
  private String idCard = "null";
  public synchronized void  pass(String boardingPass,String idCard){
    this.boardingPass = boardingPass;
    this.idCard = idCard;
    this.count ++;
    check();
  }
  private void check(){
    // 简单测试，登机牌和身份证首字母不相同时则表示检查不通过
    if(boardingPass.charAt(0) !=idCard.charAt(0)){
      throw new RuntimeException("===error===" + toString());
    }
    System.out.println("检查通过===>");
  }
  public String toString(){
    return "The" + count + "passenger,boardingPass [" + boardingPass + "],idCard [" + idCard + "]";
  }
}
