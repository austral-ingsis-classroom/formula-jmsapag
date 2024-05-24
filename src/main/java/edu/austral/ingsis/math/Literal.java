package edu.austral.ingsis.math;

import edu.austral.ingsis.math.utils.Try;

import java.util.List;
import java.util.Map;

public class Literal implements Function {

  private Double literal;

  public Literal(Double literal) {
    this.literal = literal;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> variables) {
    if (literal != null) {
      return new Try<>(literal);
    }
    return new Try<>(new Exception("Not a literal: " + literal));
  }

  @Override
  public String print() {
    return String.valueOf(literal.intValue());
  }

  @Override
  public List<String> getVariables() {
    return List.of();
  }
}
