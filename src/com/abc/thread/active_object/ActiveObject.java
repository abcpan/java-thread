package com.abc.thread.active_object;

import com.abc.thread.active_object.activeobject.Result;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 22:20
 * @project IntelliJ IDEA
 */
public interface ActiveObject {
  Result<String> makeString(int count, char fillchar);
  void displayString(String string);
}
