package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestBalancedBrackets {
  @Test
  void test_PairsOfParensReturnsTrue() {
    String expectedInput = "()";
    var sut = new BalancedBrackets();
    assertTrue(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_PairsOfBracketsReturnsTrue() {
    String expectedInput = "[]";
    var sut = new BalancedBrackets();
    assertTrue(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_PairsOfBracesReturnsTrue() {
    String expectedInput = "{}";
    var sut = new BalancedBrackets();
    assertTrue(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_SingleParenthesisReturnsFalse() {
    String expectedInput = "(";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_SingleParenthesisSurroundedByPairOFBracketsReturnsFalse() {
    String expectedInput = "[(]";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_SingleBraceSurroundedByPairOfBracesReturnsFalse() {
    String expectedInput = "{{}";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_MultiplePairsOfBracketsBracesParenthesesReturnsTrue() {
    String expectedInput = "[{}[]({({})}[])]";
    var sut = new BalancedBrackets();
    assertTrue(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_EmptyInputReturnsFalse() {
    String expectedInput = "";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_OtherInputTypesReturnsFalse() {
    String expectedInput = "abccbbbabbacddceea";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_MixedInputTypesWithoutMatchingPairsReturnsFalse() {
    String expectedInput = "{abc[cbbba)bbacddceea";
    var sut = new BalancedBrackets();
    assertFalse(sut.IsBalanced(expectedInput));
  }
  @Test
  void test_OtherInputTypesWithMatchingPairsReturnsTrue() {
    String expectedInput = "{a[b(cc)b(bb)a]b{b}{a}c[ddc()ee]a}";
    var sut = new BalancedBrackets();
    assertTrue(sut.IsBalanced(expectedInput));
  }
}
