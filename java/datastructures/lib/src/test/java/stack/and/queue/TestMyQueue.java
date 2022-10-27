package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyQueue {
  @Test
  void test_CanInstantiateMyQueue() {
    String expectedToString = "->NULL";
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.isEmpty());
    assertNotNull(sut);
    assertEquals(expectedToString, sut.toString());
    assertNull(sut.front);
    assertNull(sut.rear);
  }
  @Test
  void test_EnqueuePeekDequeue() {
    int expectedResult = 1;

    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.isEmpty());

    assertTrue(sut.enqueue(expectedResult));
    assertFalse(sut.isEmpty());

    assertEquals(expectedResult, sut.peek());
    assertFalse(sut.isEmpty());

    int actualResult = sut.dequeue();
    assertEquals(expectedResult, actualResult);
    assertTrue(sut.isEmpty());
  }
  @Test
  void test_EnqueuePeekDequeueTwoItems() {
    int expectedResultOne = 1;
    int expectedResultTwo = 2;

    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.isEmpty());

    assertTrue(sut.enqueue(expectedResultOne));
    assertFalse(sut.isEmpty());

    assertEquals(expectedResultOne, sut.peek());
    assertFalse(sut.isEmpty());

    assertTrue(sut.enqueue(expectedResultTwo));
    assertFalse(sut.isEmpty());
    assertEquals(expectedResultOne, sut.peek());

    int actualResultOne = sut.dequeue();
    assertEquals(expectedResultOne, actualResultOne);
    assertFalse(sut.isEmpty());
    assertEquals(expectedResultTwo, sut.peek());

    int actualResultTwo = sut.dequeue();
    assertEquals(expectedResultTwo, actualResultTwo);
    assertTrue(sut.isEmpty());
  }
  @Test
  void test_PeekThrowsNullPointerIfEmpty() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertThrows(NullPointerException.class, ()-> {
      sut.peek();
    });
  }
  @Test
  void test_DequeueThrowsNullPointerIfEmpty() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertThrows(NullPointerException.class, ()-> {
      sut.dequeue();
    });
  }
  @Test
  void test_IsEmptyTrueWhenEmptyFalseWhenAnyInQueue() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.isEmpty());

    sut.enqueue(1);
    assertFalse(sut.isEmpty());
  }
}
