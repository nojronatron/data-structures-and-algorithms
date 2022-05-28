package stack.and.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test void testPushOntoStackReturnsTrue() {
      Boolean expectedResult = true;
      int expectedValue = 42;
      MyStack<Integer> sut = new MyStack<>();
      Boolean actualResult = sut.push(expectedValue);
      assertEquals(expectedResult, actualResult);
    }

    @Test void testRepeatedPushOntoStackReturnsManyTrue() {
      MyStack<Integer> sut = new MyStack<>();
      assertTrue(sut.push(42));
      assertTrue(sut.push(0));
      assertTrue(sut.push(-555));
      assertTrue(sut.push(999_999_999));
      assertTrue(sut.push(11));
    }

    @Test void testPopOffOfStackReturnsExpectedValue(){
      int expectedValue = -555;
      MyStack<Integer> sut = new MyStack<>();
      assertTrue(sut.push(42));
      assertTrue(sut.push(0));
      assertTrue(sut.push(-555));
      int actualValue = sut.pop();
      assertEquals(expectedValue, actualValue);
    }

    @Test void testEmptyStackAfterMultiplePopOperations() {
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

    @Test void testPeekNextItemOnStackReturnsValue() {
      int expectedValue = 42;
      MyStack<Integer> sut = new MyStack<>();
      assertTrue(sut.push(expectedValue));
      int actualValue = sut.peek();
      assertEquals(expectedValue, actualValue);
    }

    @Test void testInstantiateEmptyStack() {
      MyStack<Integer> sut = new MyStack<>();
      assertTrue(sut.isEmpty());
    }

    @Test void testPopOrPeekOnEmptyStackRaisesException() {
      MyStack<Integer> sut = new MyStack<>();
      assertEquals(null, sut.pop());

      NullPointerException thrown = null;
      
      thrown = assertThrows(NullPointerException.class, ()-> {
        sut.peek();
      });

      assertEquals("Cannot read field \"value\" because \"this.top\" is null", thrown.getMessage());
    }

    @Test void testCanEnqueueIntoQueue(){

      assertTrue(false);
    }

    @Test void testEnqueueManyIntoQueue() {

      assertTrue(false);
    }

    @Test void testDequeueOutOfQueueReturnsExpectedValue() {

      assertTrue(false);
    }

    @Test void testPeekIntoQueueReturnsExpectedValue() {

      assertTrue(false);
    }

    @Test void testCanEmptyQueueUsingMultipleDequeues() {

      assertTrue(false);
    }

    @Test void testCanInstantiateAnEmptyQueue() {

      assertTrue(false);
    }

    @Test void testCallingDequeueOrPeekOnEmptyQueueRaisesException() {

      assertTrue(false);
    }
}
