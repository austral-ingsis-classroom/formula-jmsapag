package edu.austral.ingsis.math.binary;

import edu.austral.ingsis.math.Function;
import edu.austral.ingsis.math.utils.Try;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Binary implements Function {

  private final Function left;
  private final Function right;
  private final BinaryType operator;
  private final Mapper mapper;

  // constructor: has two functions, an operator and a mapper
  public Binary(Function left, Function right, BinaryType operator) {
    this.left = left;
    this.right = right;
    this.operator = operator;
    this.mapper = new Mapper();
  }

  @Override
  public Try<Double, Exception> resolve(Map<String, Double> variables) {

    // resolve both left and right, get the operator
    Try<Double, Exception> leftResult = left.resolve(variables);
    Try<Double, Exception> rightResult = right.resolve(variables);
    Optional<BinaryOperator<Double>> optionalOperator = mapper.getOperatorFunction(operator);

    if (optionalOperator.isEmpty()) {
      return new Try<>(new Exception("No operator found"));
    }

    // handle success and resolve
    if (leftResult.isSuccess() && rightResult.isSuccess()) {
      Double result =
          optionalOperator.get().apply(leftResult.getSuccess(), rightResult.getSuccess());
      return new Try<>(result);
    }

    // handle errors
    StringBuilder errorMessage = new StringBuilder();
    if (leftResult.isFail()) {
      errorMessage
          .append("Left side failed: ")
          .append(leftResult.getFail().getMessage())
          .append(". ");
    }
    if (rightResult.isFail()) {
      errorMessage
          .append("Right side failed: ")
          .append(rightResult.getFail().getMessage())
          .append(".");
    }

    return new Try<>(
        new Exception("Failed to resolve binary operation: " + errorMessage.toString().trim()));
  }

  @Override
  public String print() {
    return left.print() + " " + mapper.getOperatorSymbol(operator) + " " + right.print();
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }
}
