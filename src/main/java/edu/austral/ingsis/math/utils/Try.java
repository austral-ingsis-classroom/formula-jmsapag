package edu.austral.ingsis.math.utils;

public class Try<S, F extends Exception> {

  private S success;
  private F fail;

  public Try(S success) {
    this.success = success;
  }

  public Try(F fail) {
    this.fail = fail;
  }

  public S getSuccess() {
    return success;
  }

  public boolean isSuccess() {
    return success != null;
  }

  public F getFail() {
    return fail;
  }

  public boolean isFail() {
    return fail != null;
  }
}
