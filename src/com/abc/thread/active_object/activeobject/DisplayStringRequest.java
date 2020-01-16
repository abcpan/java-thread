package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:24
 * @project IntelliJ IDEA
 */
public class DisplayStringRequest extends MethodRequest<Object> {
  private final String string;

  public DisplayStringRequest(Servant servant, String string) {
    super(servant, null);
    this.string = string;
  }

  @Override
  public void execute() {
    servant.displayString(string);
  }
}
