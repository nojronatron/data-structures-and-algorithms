package stack.and.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  @Test
  void testPushOntoStackReturnsTrue() {
    Boolean expectedResult = true;
    int expectedValue = 42;
    MyStack<Integer> sut = new MyStack<>();
    Boolean actualResult = sut.push(expectedValue);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void testRepeatedPushOntoStackReturnsManyTrue() {
    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.push(42));
    assertTrue(sut.push(0));
    assertTrue(sut.push(-555));
    assertTrue(sut.push(999_999_999));
    assertTrue(sut.push(11));
  }

  @Test
  void testPopOffOfStackReturnsExpectedValue() {
    int expectedValue = -555;
    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.push(42));
    assertTrue(sut.push(0));
    assertTrue(sut.push(-555));
    int actualValue = sut.pop();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  void testEmptyStackAfterMultiplePopOperations() {
    int expectedValue3 = 42;
    int expectedValue2 = 0;
    int expectedValue1 = -555;

    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.push(expectedValue3));
    assertTrue(sut.push(expectedValue2));
    assertTrue(sut.push(expectedValue1));

    assertEquals(expectedValue1, sut.pop());
    assertEquals(expectedValue2, sut.pop());
    assertEquals(expectedValue3, sut.pop());

    assertTrue(sut.isEmpty());
  }

  @Test
  void testPeekNextItemOnStackReturnsValue() {
    int expectedValue = 42;
    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.push(expectedValue));
    int actualValue = sut.peek();
    assertEquals(expectedValue, actualValue);
  }

  @Test
  void testInstantiateEmptyStack() {
    MyStack<Integer> sut = new MyStack<>();
    assertTrue(sut.isEmpty());
  }

  @Test
  void testPopOrPeekOnEmptyStackRaisesException() {
    MyStack<Integer> sut = new MyStack<>();
    assertEquals(null, sut.pop());

    NullPointerException thrown = null;

    thrown = assertThrows(NullPointerException.class, () -> {
      sut.peek();
    });

    assertEquals("Cannot read field \"value\" because \"this.top\" is null", thrown.getMessage());
  }

  @Test
  void testCanEnqueueIntoQueue() {
    boolean expectedResult = true;
    MyQueue<Integer> sut = new MyQueue<>();
    boolean actualResult = sut.enqueue(42);
    System.out.println(sut);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void testEnqueueManyIntoQueue() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.enqueue(42));
    System.out.println(sut);
    assertTrue(sut.enqueue(-11));
    System.out.println(sut);
    assertTrue(sut.enqueue(0));
    System.out.println(sut);
    assertTrue(sut.enqueue(999_999_999));
    System.out.println(sut);
  }

  @Test
  void testDequeueOutOfQueueReturnsExpectedValue() {
    int expectedValue = 42;
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.enqueue(expectedValue));
    System.out.println(sut);
    assertEquals(expectedValue, sut.dequeue(), "Dequeue returns value input which was 42.");
  }

  @Test
  void testPeekIntoQueueReturnsExpectedValue() {
    int expectedValue = -11;
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.enqueue(expectedValue));
    System.out.println(sut);
    assertTrue(sut.enqueue(42));
    System.out.println(sut);
    assertEquals(expectedValue, sut.peek());
  }

  @Test
  void testCanEmptyQueueUsingMultipleDequeues() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.enqueue(42));
    System.out.println(sut);
    assertTrue(sut.enqueue(-11));
    System.out.println(sut);
    assertTrue(sut.enqueue(0));
    System.out.println(sut);

    assertEquals(42, sut.dequeue());
    assertEquals(-11, sut.dequeue());
    assertEquals(0, sut.dequeue());
    assertTrue(sut.isEmpty());
  }

  @Test
  void testCanInstantiateAnEmptyQueue() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertTrue(sut.isEmpty());
  }

  @Test
  void testCallingDequeueOrPeekOnEmptyQueueRaisesException() {
    MyQueue<Integer> sut = new MyQueue<>();
    assertEquals(null, sut.dequeue());

    NullPointerException thrown = null;

    thrown = assertThrows(NullPointerException.class, () -> {
      sut.peek();
    });

    assertEquals("Cannot read field \"value\" because \"this.front\" is null", thrown.getMessage());
  }
}
