package edu.austral.ingsis.math.binary;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Mapper {

  private final Map<BinaryType, BinaryOperator<Double>> operators;

  public Mapper() {
    this.operators = createOperators();
  }

  // create map of operators
  private Map<BinaryType, BinaryOperator<Double>> createOperators() {
    Map<BinaryType, BinaryOperator<Double>> operatorsMap = new HashMap<>();
    operatorsMap.put(BinaryType.ADD, Double::sum);
    operatorsMap.put(BinaryType.SUBTRACT, (a, b) -> a - b);
    operatorsMap.put(BinaryType.MULTIPLY, (a, b) -> a * b);
    operatorsMap.put(BinaryType.DIVIDE, (a, b) -> a / b);
    operatorsMap.put(BinaryType.POWER, Math::pow);
    return operatorsMap;
  }

  public Optional<BinaryOperator<Double>> getOperatorFunction(BinaryType operator) {
    return Optional.ofNullable(operators.get(operator));
  }

  public String getOperatorSymbol(BinaryType operator) {
    switch (operator) {
      case ADD:
        return "+";
      case SUBTRACT:
        return "-";
      case MULTIPLY:
        return "*";
      case DIVIDE:
        return "/";
      case POWER:
        return "^";
      default:
        throw new IllegalArgumentException("Unknown operator: " + operator);
    }
  }
}
