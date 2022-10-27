package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyStack {
  @Test
  void test_canInstantiateMyStack() {
    MyStack<Integer> sut = new MyStack<>();
    assertNotNull(sut);
  }

  @Test
  void test_canPushOntoStack() {
    int expectedValue = 11;
    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.isEmpty());
    assertTrue(sut.push(expectedValue));
    assertFalse(sut.isEmpty());
  }

  @Test
  void test_canPushMultipleOntoStack() {
    String expectedFirstValue = "s";
    String expectedSecondValue = "e";
    String expectedThirdValue = "y";

    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());
    assertTrue(sut.push(expectedFirstValue));
    assertFalse(sut.isEmpty());
    assertTrue(sut.push(expectedSecondValue));
    assertFalse(sut.isEmpty());
    assertTrue(sut.push(expectedThirdValue));
    assertFalse(sut.isEmpty());
  }

  @Test
  void test_canPopOffStack() {
    String expectedFirstValue = "yes";

    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());
    assertTrue(sut.push(expectedFirstValue));
    assertFalse(sut.isEmpty());

    String actualResult = sut.pop();
    assertTrue(sut.isEmpty());
    assertEquals(expectedFirstValue, actualResult);
  }

  @Test
  void test_canEmptyStackAfterMultiplePops() {
    String expectedFirstValue = "s";
    String expectedSecondValue = "e";
    String expectedThirdValue = "y";

    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.push(expectedFirstValue));
    assertTrue(sut.push(expectedSecondValue));
    assertTrue(sut.push(expectedThirdValue));

    assertEquals(expectedThirdValue, sut.pop());
    assertFalse(sut.isEmpty());

    assertEquals(expectedSecondValue, sut.pop());
    assertFalse(sut.isEmpty());

    assertEquals(expectedFirstValue, sut.pop());
    assertTrue(sut.isEmpty());
  }

  @Test
  void test_canPeekTopItemOnStack() {
    String expectedFirstValue = "yes";
    String expectedSecondValue = "me too";
    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());
    assertTrue(sut.push(expectedFirstValue));
    assertFalse(sut.isEmpty());

    String actualFirstResult = sut.peek();
    assertEquals(expectedFirstValue, actualFirstResult);
    assertFalse(sut.isEmpty());

    assertTrue(sut.push(expectedSecondValue));
    String actualSecondResult = sut.peek();
    assertEquals(expectedSecondValue, actualSecondResult);
  }

  @Test
  void test_callingPopOnEmptyStackRaisesException() {
    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());
    assertThrows(NullPointerException.class, () -> {
      sut.pop();
    });
    assertTrue(sut.isEmpty());
  }

  @Test
  void test_callingPeekOnEmptyStackRaisesException() {
    String expectedSingleValue = "1";
    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());
    assertThrows(NullPointerException.class, () -> {
      sut.peek();
    });

    assertTrue(sut.push(expectedSingleValue));
    assertDoesNotThrow(() -> {
      sut.peek();
    });
  }

  @Test
  void test_isEmptyReturnsTrueWhenEmptyAndFalseWhenHasItems() {
    String expectedFirstValue = "yes";

    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.isEmpty());

    assertTrue(sut.push(expectedFirstValue));
    assertFalse(sut.isEmpty());

    sut.pop();
    assertTrue(sut.isEmpty());
  }

  @Test
  void test_toStringReturnsCorrectSequence() {
    String expectedResult = "[y]->[e]->[s]->NULL";
    String expectedFirstValue = "s";
    String expectedSecondValue = "e";
    String expectedThirdValue = "y";

    MyStack<String> sut = new MyStack<>();

    assertTrue(sut.push(expectedFirstValue));
    assertTrue(sut.push(expectedSecondValue));
    assertTrue(sut.push(expectedThirdValue));

    String actualResult = sut.toString();
    assertEquals(expectedResult, actualResult);
  }
}
