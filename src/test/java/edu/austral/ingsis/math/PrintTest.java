package edu.austral.ingsis.math;

import edu.austral.ingsis.math.binary.Binary;
import edu.austral.ingsis.math.binary.BinaryType;
import edu.austral.ingsis.math.unary.Module;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    final String expected = "1 + 6";
    Literal one = new Literal(1.0);
    BinaryType add = BinaryType.ADD;
    Literal six = new Literal(6.0);
    Binary sum = new Binary(one, six, add);
    final String result = sum.print();
    assertThat(result, equalTo(expected));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    final String expected = "12 / 2";
    Literal twelve = new Literal(12.0);
    BinaryType divide = BinaryType.DIVIDE;
    Literal two = new Literal(2.0);
    Binary division = new Binary(twelve, two, divide);
    final String result = division.print();
    assertThat(result, equalTo(expected));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Formatter formatter = new Formatter();
    final String expected = "(9 / 2) * 3";
    Literal nine = new Literal(9.0);
    BinaryType divide = BinaryType.DIVIDE;
    Literal two = new Literal(2.0);
    Binary division = new Binary(nine, two, divide);
    Literal three = new Literal(3.0);
    final String result = formatter.format(division, " * ", three);
    assertThat(result, equalTo(expected));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Formatter formatter = new Formatter();
    final String expected = "(27 / 6) ^ 2";
    Literal n = new Literal(27.0);
    BinaryType divide = BinaryType.DIVIDE;
    Literal m = new Literal(6.0);
    Binary division = new Binary(n, m, divide);
    Literal a = new Literal(2.0);
    final String result = formatter.format(division, " ^ ", a);
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    final String expected = "|value| - 8";
    Variable value = new Variable("value");
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal eight = new Literal(8.0);
    Module module = new Module(value);
    Binary opp = new Binary(module, eight, subtract);
    final String result = opp.print();
    assertThat(result, equalTo(expected));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    final String expected = "|value| - 8";
    Variable value = new Variable("value");
    BinaryType subtract = BinaryType.SUBTRACT;
    Literal eight = new Literal(8.0);
    Module module = new Module(value);
    Binary opp = new Binary(module, eight, subtract);
    final String result = opp.print();
    assertThat(result, equalTo(expected));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    Formatter formatter = new Formatter();
    final String expected = "(5 - i) * 8";
    Literal n = new Literal(5.0);
    BinaryType subtract = BinaryType.SUBTRACT;
    Variable i = new Variable("i");
    Binary opp = new Binary(n, i, subtract);
    Literal m = new Literal(8.0);
    final String result = formatter.format(opp, " * ", m);
    assertThat(result, equalTo(expected));
  }
}
