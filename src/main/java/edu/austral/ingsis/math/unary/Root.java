package edu.austral.ingsis.math.unary;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.utils.Try;
import java.util.List;
import java.util.Map;

public class Root extends Unary {

  public Root(Function function) {
    super(function);
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> variables) {

    // get the solution of the function
    Try<Double, Exception> possibleResult = getFunction().resolve(variables);

    // if it is a failure return the failure
    if (possibleResult.isFail()) {
      return new Try<>(possibleResult.getFail());
    }

    // resolve
    Double result = possibleResult.getSuccess();
    Double newResult = Math.sqrt(result);
    return new Try<>(newResult);
  }

  @Override
  public String print() {
    return getFunction().print() + " ^ 1/2";
  }

  @Override
  public List<String> getVariables() {
    return getFunction().getVariables();
  }
}
