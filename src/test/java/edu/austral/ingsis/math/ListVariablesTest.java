package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.Binary;
import edu.austral.ingsis.math.binary.BinaryType;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Root;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Literal a = new Literal(1.0);
    Literal b = new Literal(6.0);
    BinaryType add = BinaryType.ADD;
    Binary opp = new Binary(a, b, add);
    List<String> result = opp.getVariables();
    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Literal a = new Literal(12.0);
    Variable variable = new Variable("div");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, variable, divide);
    List<String> result = opp.getVariables();
    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Literal a = new Literal(9.0);
    Variable v1 = new Variable("x");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, v1, divide);
    Variable v2 = new Variable("y");
    BinaryType multiply = BinaryType.MULTIPLY;
    Binary opp2 = new Binary(opp, v2, multiply);
    List<String> result = opp2.getVariables();
    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Literal a = new Literal(27.0);
    Variable v1 = new Variable("a");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, v1, divide);
    Variable v2 = new Variable("b");
    BinaryType power = BinaryType.POWER;
    Binary opp2 = new Binary(opp, v2, power);
    List<String> result = opp2.getVariables();
    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Variable v1 = new Variable("z");
    Root root = new Root(v1);
    List<String> result = root.getVariables();
    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Variable v1 = new Variable("value");
    Module module = new Module(v1);
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal a = new Literal(8.0);
    Binary opp = new Binary(module, a, subtract);
    List<String> result = opp.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Variable v1 = new Variable("value");
    Module module = new Module(v1);
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal a = new Literal(8.0);
    Binary opp = new Binary(module, a, subtract);
    List<String> result = opp.getVariables();
    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Literal a = new Literal(5.0);
    Variable v1 = new Variable("i");
    BinaryType subtract = BinaryType.SUBTRACT;
    Binary opp = new Binary(a, v1, subtract);
    BinaryType multiply = BinaryType.MULTIPLY;
    Literal b = new Literal(8.0);
    Binary opp2 = new Binary(opp, b, multiply);
    List<String> result = opp2.getVariables();
    assertThat(result, containsInAnyOrder("i"));
  }
}
