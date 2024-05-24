package edu.austral.ingsis.math;

public class Formatter {

  public String format(Function opp, String s, Function m) {
    return "(" + opp.print() + ")" + s + m.print();
  }
}
