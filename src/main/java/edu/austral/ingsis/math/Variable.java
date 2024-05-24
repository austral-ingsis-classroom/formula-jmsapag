package edu.austral.ingsis.math;

import edu.austral.ingsis.math.utils.Try;
import java.util.List;
import java.util.Map;

public class Variable implements Function {

  private String name;

  public Variable(String name) {
    this.name = name;
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> variables) {
    if (variables.containsKey(name)) {
      return new Try<>(variables.get(name));
    }
    return new Try<>(new Exception("Not a variable: " + name));
  }

  @Override
  public String print() {
    return name;
  }

  @Override
  public List<String> getVariables() {
    return List.of(name);
  }
}
