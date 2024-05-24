package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.Binary;
import edu.austral.ingsis.math.binary.BinaryType;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Root;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Literal a = new Literal(1.0);
    Variable variable = new Variable("x");
    BinaryType add = BinaryType.ADD;
    Binary opp = new Binary(a, variable, add);
    HashMap<String, Double> map = new HashMap<>();
    map.put("x", 3.0);
    Double result = opp.resolve(map).getSuccess();
    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Literal a = new Literal(12.0);
    Variable variable = new Variable("div");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, variable, divide);
    HashMap<String, Double> map = new HashMap<>();
    map.put("div", 4.0);
    Double result = opp.resolve(map).getSuccess();
    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Literal a = new Literal(9.0);
    Variable v1 = new Variable("x");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, v1, divide);
    Variable v2 = new Variable("y");
    BinaryType multiply = BinaryType.MULTIPLY;
    Binary opp2 = new Binary(opp, v2, multiply);
    HashMap<String, Double> map = new HashMap<>();
    map.put("x", 3.0);
    map.put("y", 4.0);
    Double result = opp2.resolve(map).getSuccess();
    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Literal a = new Literal(27.0);
    Variable v1 = new Variable("a");
    BinaryType divide = BinaryType.DIVIDE;
    Binary opp = new Binary(a, v1, divide);
    Variable v2 = new Variable("b");
    BinaryType power = BinaryType.POWER;
    Binary opp2 = new Binary(opp, v2, power);
    HashMap<String, Double> map = new HashMap<>();
    map.put("a", 9.0);
    map.put("b", 3.0);
    Double result = opp2.resolve(map).getSuccess();
    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Variable v1 = new Variable("z");
    Root root = new Root(v1);
    HashMap<String, Double> map = new HashMap<>();
    map.put("z", 36.0);
    Double result = root.resolve(map).getSuccess();
    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Variable v1 = new Variable("value");
    Module module = new Module(v1);
    HashMap<String, Double> map = new HashMap<>();
    map.put("value", 8.0);
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal a = new Literal(8.0);
    Binary opp = new Binary(module, a, subtract);
    Double result = opp.resolve(map).getSuccess();
    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Variable v1 = new Variable("value");
    Module module = new Module(v1);
    HashMap<String, Double> map = new HashMap<>();
    map.put("value", 8.0);
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal a = new Literal(8.0);
    Binary opp = new Binary(module, a, subtract);
    Double result = opp.resolve(map).getSuccess();
    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Literal a = new Literal(5.0);
    Variable v1 = new Variable("i");
    BinaryType subtract = BinaryType.SUBTRACT;
    Binary opp = new Binary(a, v1, subtract);
    BinaryType multiply = BinaryType.MULTIPLY;
    Literal b = new Literal(8.0);
    Binary opp2 = new Binary(opp, b, multiply);
    HashMap<String, Double> map = new HashMap<>();
    map.put("i", 2.0);
    Double result = opp2.resolve(map).getSuccess();
    assertThat(result, equalTo(24d));
  }
}
