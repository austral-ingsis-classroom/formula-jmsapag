package edu.austral.ingsis.math;

import edu.austral.ingsis.math.utils.Try;

import java.util.List;
import java.util.Map;

// use of composite pattern

public interface Function {

  public Try<Double, Exception> resolve(Map<String, Double> variables);

  public String print();

  public List<String> getVariables();
}
