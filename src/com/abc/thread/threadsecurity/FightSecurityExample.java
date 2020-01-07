package com.abc.thread.threadsecurity;

/**
 * @author abcpan
 * @version 1.0
 * @date 2020/1/7 16:55
 */
public class FightSecurityExample {
  static class Passengers extends Thread{
    // 机场安检类
    private final FightSecurity fightSecurity;

    // 旅客的身份
    private final String idCard;
    // 旅客的登机牌
    private final String boardingPass;

    public Passengers(FightSecurity fightSecurity,String idCard,String boardingPass){
      this.fightSecurity = fightSecurity;
      this.idCard = idCard;
      this.boardingPass = boardingPass;
    }

    @Override
    public void run() {
      // 旅客不断地进行安检
      while (true){
        fightSecurity.pass(boardingPass,idCard);
      }
    }
  }

  public static void main(String[] args){
    final FightSecurity fightSecurity = new FightSecurity();
    new Passengers(fightSecurity,"A123456","AF123456").start();
    new Passengers(fightSecurity,"B123456","BF123456").start();
    new Passengers(fightSecurity,"C123456","CF123456").start();
    new Passengers(fightSecurity,"D123456","DF123456").start();
  }
}
