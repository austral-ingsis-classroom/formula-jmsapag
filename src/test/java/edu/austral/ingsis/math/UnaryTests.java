package edu.austral.ingsis.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Root;
import edu.austral.ingsis.math.utils.Try;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class UnaryTests {

  @Test
  public void testResolveWithLiteralRoot() {
    Function literal = new Literal(16.0);
    Root root = new Root(literal);

    Try<Double, Exception> result = root.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(4.0, result.getSuccess());
  }

  @Test
  public void testResolveWithVariableRoot() {
    Function variable = new Variable("x");
    Root root = new Root(variable);

    Try<Double, Exception> result = root.resolve(Map.of("x", 9.0));

    assertTrue(result.isSuccess());
    assertEquals(3.0, result.getSuccess());
  }

  @Test
  public void testResolveWithMissingVariableRoot() {
    Function variable = new Variable("x");
    Root root = new Root(variable);

    Try<Double, Exception> result = root.resolve(Map.of());

    assertTrue(result.isFail());
    assertEquals("Not a variable: x", result.getFail().getMessage());
  }

  @Test
  public void testResolveWithNegativeLiteralRoot() {
    Function literal = new Literal(-1.0);
    Root root = new Root(literal);

    Try<Double, Exception> result = root.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertTrue(Double.isNaN(result.getSuccess())); // Math.sqrt(-1) returns NaN
  }

  @Test
  public void testPrintRoot() {
    Function literal = new Literal(16.0);
    Root root = new Root(literal);

    String result = root.print();

    assertEquals("16 ^ 1/2", result);
  }

  @Test
  public void testGetVariablesRoot() {
    Function variable = new Variable("x");
    Root root = new Root(variable);

    List<String> variables = root.getVariables();

    assertEquals(List.of("x"), variables);
  }

  @Test
  public void testResolveWithPositiveLiteralModule() {
    Function literal = new Literal(5.0);
    Module module = new Module(literal);

    Try<Double, Exception> result = module.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(5.0, result.getSuccess());
  }

  @Test
  public void testResolveWithNegativeLiteralModule() {
    Function literal = new Literal(-5.0);
    Module module = new Module(literal);

    Try<Double, Exception> result = module.resolve(Map.of());

    assertTrue(result.isSuccess());
    assertEquals(5.0, result.getSuccess());
  }

  @Test
  public void testResolveWithVariableModule() {
    Function variable = new Variable("x");
    Module module = new Module(variable);

    Try<Double, Exception> result = module.resolve(Map.of("x", -9.0));

    assertTrue(result.isSuccess());
    assertEquals(9.0, result.getSuccess());
  }

  @Test
  public void testResolveWithMissingVariableModule() {
    Function variable = new Variable("x");
    Module module = new Module(variable);

    Try<Double, Exception> result = module.resolve(Map.of());

    assertTrue(result.isFail());
    assertEquals("Not a variable: x", result.getFail().getMessage());
  }

  @Test
  public void testPrintModule() {
    Function literal = new Literal(-5.0);
    Module module = new Module(literal);

    String result = module.print();

    assertEquals("|-5|", result);
  }

  @Test
  public void testGetVariablesModule() {
    Function variable = new Variable("x");
    Module module = new Module(variable);

    List<String> variables = module.getVariables();

    assertEquals(List.of("x"), variables);
  }
}
