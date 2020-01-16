package com.abc.thread.active_object.activeobject;

import com.abc.thread.active_object.ActiveObject;
import com.abc.thread.active_object.DisplayClientThread;
import com.abc.thread.active_object.MakerClientThread;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:26
 * @project IntelliJ IDEA
 */
public class Proxy implements ActiveObject {
  private final SchedulerThread scheduler;
  private final Servant servant;
  public Proxy(SchedulerThread scheduler,Servant servant){
    this.scheduler = scheduler;
    this.servant = servant;
  }
  @Override
  public Result<String> makeString(int count, char fillchar) {
     FutureResult<String> future = new FutureResult<>();
    scheduler.invoke(new MakeStringRequest(servant,future,count,fillchar));
    return future;
  }

  @Override
  public void displayString(String value) {
    scheduler.invoke(new DisplayStringRequest(servant,value));
  }
}
