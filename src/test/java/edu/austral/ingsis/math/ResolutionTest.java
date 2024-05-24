package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.Binary;
import edu.austral.ingsis.math.binary.BinaryType;
import edu.austral.ingsis.math.unary.Module;
import edu.austral.ingsis.math.unary.Root;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Literal one = new Literal(1.0);
    BinaryType add = BinaryType.ADD;
    Literal six = new Literal(6.0);
    Binary sum = new Binary(one, six, add);
    final Double result = sum.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(7d));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Literal twelve = new Literal(12.0);
    BinaryType divide = BinaryType.DIVIDE;
    Literal two = new Literal(2.0);
    Binary division = new Binary(twelve, two, divide);
    final Double result = division.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(6d));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Literal a = new Literal(9.0);
    Literal b = new Literal(2.0);
    BinaryType divide = BinaryType.DIVIDE;
    Binary division = new Binary(a, b, divide);
    BinaryType multiply = BinaryType.MULTIPLY;
    Literal c = new Literal(3.0);
    Binary result2 = new Binary(division, c, multiply);
    Double result = result2.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(13.5d));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Literal a = new Literal(27.0);
    Literal b = new Literal(6.0);
    BinaryType divide = BinaryType.DIVIDE;
    Binary division = new Binary(a, b, divide);
    BinaryType power = BinaryType.POWER;
    Literal c = new Literal(2.0);
    Binary result2 = new Binary(division, c, power);
    Double result = result2.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(20.25d));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Literal a = new Literal(36.0);
    Root root = new Root(a);
    Double result = root.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(6d));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Literal a = new Literal(136.0);
    Module module = new Module(a);
    Double result = module.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(136d));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Literal a = new Literal(-136.0);
    Module module = new Module(a);
    Double result = module.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(136d));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Literal a = new Literal(5.0);
    BinaryType subtract = BinaryType.SUBTRACT;
    Binary opp = new Binary(a, a, subtract);
    BinaryType multiply = BinaryType.MULTIPLY;
    Literal c = new Literal(8.0);
    Binary result2 = new Binary(opp, c, multiply);
    Double result = result2.resolve(new HashMap<>()).getSuccess();
    assertThat(result, equalTo(0d));
  }
}
