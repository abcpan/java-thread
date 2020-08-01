package com.abc.thread.active_object;


import com.abc.thread.active_object.activeobject.ActivationQueue;
import com.abc.thread.active_object.activeobject.Proxy;
import com.abc.thread.active_object.activeobject.Servant;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:21
 * @project IntelliJ IDEA
 */
public class ActiveObjectFactory {
  public static ActiveObject createActiveObject(){
    // gen the scheduler
    ActivationQueue queue = new ActivationQueue();
    Proxy.SchedulerThread scheduler = new Proxy.SchedulerThread(queue);
    //
    Servant servant = new Servant();
    //
    Proxy proxy = new Proxy(scheduler,servant);
    scheduler.start();
    return proxy;
  }
}
