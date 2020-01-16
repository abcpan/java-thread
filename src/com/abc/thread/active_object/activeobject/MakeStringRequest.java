package com.abc.thread.active_object.activeobject;

/**
 * @author abc.pan
 * @version 1.00
 * @time 2020/1/16 23:18
 * @project IntelliJ IDEA
 */
public class MakeStringRequest extends MethodRequest<String> {
  private final int count;
  private final char fillchar;
  public MakeStringRequest(Servant servant, FutureResult<String> future, int count, char fillchar) {
    super(servant, future);
    this.count = count;
    this.fillchar = fillchar;
  }

  @Override
  public void execute() {
    Result<String> result = servant.makeString(count,fillchar);
    future.setResult(result);
  }
}
