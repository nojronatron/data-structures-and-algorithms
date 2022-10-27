package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestMyStack {
  @Test
  void test_canInstantiateMyStack() {
    MyStack<Integer> sut = new MyStack<>();
    assertNotNull(sut);
  }
  @Test
  void test_canPushOntoStack() {

  }
  @Test
  void test_canPushMultipleOntoStack() {

  }
  @Test
  void test_canPopOffStack() {

  }
  @Test
  void test_canEmptyStackAfterMultiplePops() {

  }
  @Test
  void test_canPeekTopItemOnStack() {

  }
  @Test
  void test_callingPopOnEmptyStackRaisesException() {

  }
  @Test
  void test_callingPeekOnEmptyStackRaisesException() {

  }
  @Test
  void test_isEmptyReturnsTrueWhenEmptyFalseWhenHasItems() {

  }
}
