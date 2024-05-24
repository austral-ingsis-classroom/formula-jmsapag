package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.austral.ingsis.math.binary.Binary;
import edu.austral.ingsis.math.binary.BinaryType;
import edu.austral.ingsis.math.utils.Try;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class BinaryTests {

  @Test
  public void testResolveAddition() {
    Function left = new Literal(2.0);
    Function right = new Literal(3.0);
    Binary binary = new Binary(left, right, BinaryType.ADD);

    Try<Double, Exception> result = binary.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(5.0, result.getSuccess());
  }

  @Test
  public void testResolveSubtraction() {
    Function left = new Literal(5.0);
    Function right = new Literal(3.0);
    Binary binary = new Binary(left, right, BinaryType.SUBTRACT);

    Try<Double, Exception> result = binary.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(2.0, result.getSuccess());
  }

  @Test
  public void testResolveMultiplication() {
    Function left = new Literal(2.0);
    Function right = new Literal(3.0);
    Binary binary = new Binary(left, right, BinaryType.MULTIPLY);

    Try<Double, Exception> result = binary.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(6.0, result.getSuccess());
  }

  @Test
  public void testResolveDivision() {
    Function left = new Literal(6.0);
    Function right = new Literal(3.0);
    Binary binary = new Binary(left, right, BinaryType.DIVIDE);

    Try<Double, Exception> result = binary.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(2.0, result.getSuccess());
  }

  @Test
  public void testResolveWithVariable() {
    Function left = new Literal(6.0);
    Function right = new Variable("x");
    Binary binary = new Binary(left, right, BinaryType.DIVIDE);

    Try<Double, Exception> result = binary.resolve(Map.of("x", 2.0));

    assertTrue(result.isSuccess());
    assertEquals(3.0, result.getSuccess());
  }

  @Test
  public void testResolveWithMissingVariable() {
    Function left = new Literal(6.0);
    Function right = new Variable("x");
    Binary binary = new Binary(left, right, BinaryType.DIVIDE);

    Try<Double, Exception> result = binary.resolve(Map.of());

    assertTrue(result.isFail());
    assertEquals(
        "Failed to resolve binary operation: Right side failed: Not a variable: x.",
        result.getFail().getMessage());
  }

  @Test
  public void testPrint() {
    Function left = new Literal(2.0);
    Function right = new Literal(3.0);
    Binary binary = new Binary(left, right, BinaryType.ADD);

    String result = binary.print();

    assertEquals("2 + 3", result);
  }

  @Test
  public void testGetVariables() {
    Function left = new Variable("x");
    Function right = new Variable("y");
    Binary binary = new Binary(left, right, BinaryType.ADD);

    List<String> variables = binary.getVariables();

    assertTrue(variables.contains("x"));
    assertTrue(variables.contains("y"));
    assertEquals(2, variables.size());
  }
}
