package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;

// decided to make an abstract class because behaviour is really different

public abstract class Unary implements Function {

  private final Function function;

  public Unary(Function function) {
    this.function = function;
  }

  public Function getFunction() {
    return function;
  }
}
