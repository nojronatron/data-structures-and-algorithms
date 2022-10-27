package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPseudoQueue {
  @Test
  void test_CanInstantiatePseudoQueue() {
    int expectedCount = 0;
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertNotNull(sut);
    int actualCount = sut.count;
    assertEquals(expectedCount, actualCount);
  }
  @Test
  void test_DequeueOnEmptyReturnsNull() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertNull(sut.dequeue());
  }
  @Test
  void test_EnqueueOnEmptyIncrementsCount() {
    int expectedValue = 11;
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertEquals(0, sut.count);
    sut.enqueue(expectedValue);
    assertEquals(1, sut.count);
  }
  @Test
  void test_EnqueueAndDequeueMultipleTimesIsProperlyTrackedByCount() {
    int expectedFirstValue = 11;
    int expectedSecondValue = 12;
    int expectedThirdValue = 13;

    PseudoQueue<Integer> sut = new PseudoQueue<>();

    assertEquals(0, sut.count);
    assertTrue(sut.enqueue(expectedFirstValue));
    assertEquals(1, sut.count);

    assertTrue(sut.enqueue(expectedSecondValue));
    assertEquals(2, sut.count);

    int actualFirstValue = sut.dequeue();
    assertEquals(expectedFirstValue, actualFirstValue);
    assertEquals(1, sut.count);

    assertTrue(sut.enqueue(expectedThirdValue));
    assertEquals(2, sut.count);

    int actualSecondValue = sut.dequeue();
    assertEquals(expectedSecondValue, actualSecondValue);
    assertEquals(1, sut.count);

    int actualThirdValue = sut.dequeue();
    assertEquals(expectedThirdValue, actualThirdValue);
    assertEquals(0, sut.count);
  }
  @Test
  void test_EnqueueDequeueReturnsFifoValues() {
    int expectedFirstValue = 11;
    int expectedSecondValue = 12;
    int expectedThirdValue = 13;

    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertTrue(sut.enqueue(expectedFirstValue));
    assertTrue(sut.enqueue(expectedSecondValue));
    assertTrue(sut.enqueue(expectedThirdValue));

    int actualFirstValue = sut.dequeue();
    assertEquals(expectedFirstValue, actualFirstValue);
    int actualSecondValue = sut.dequeue();
    assertEquals(expectedSecondValue, actualSecondValue);
    int actualThirdValue = sut.dequeue();
    assertEquals(expectedThirdValue, actualThirdValue);
  }
  @Test
  void test_PeekOnEmptyQueueReturnsNull() {
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertNull(sut.peek());
  }
  @Test
  void test_PeekOnNonNullQueueReturnsCorrectValue() {
    int expectedValue = 11;
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertEquals(0, sut.count);
    sut.enqueue(expectedValue);
    assertEquals(1, sut.count);

    int actualValue = sut.peek();
    assertEquals(expectedValue, actualValue);
    assertEquals(1, sut.count);
  }
  @Test
  void test_EnqueueLotsPeekOneEnqueueMoreDequeueAllStillInFifoOrder() {
    int expectedFirstValue = 11;
    int expectedSecondValue = 12;
    int expectedThirdValue = 13;
    int expectedFourthValue = 14;
    int expectedFifthValue = 15;
    int expectedSixthValue = 16;

    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertEquals(0, sut.count);

    assertTrue(sut.enqueue(expectedFirstValue));
    assertTrue(sut.enqueue(expectedSecondValue));
    assertTrue(sut.enqueue(expectedThirdValue));
    assertEquals(3, sut.count);

    int actualPeekValue = sut.peek();
    assertEquals(expectedFirstValue, actualPeekValue);

    assertTrue(sut.enqueue(expectedFourthValue));
    assertTrue(sut.enqueue(expectedFifthValue));
    assertTrue(sut.enqueue(expectedSixthValue));
    assertEquals(6, sut.count);

    assertEquals(expectedFirstValue, sut.dequeue());
    assertEquals(expectedSecondValue, sut.dequeue());
    assertEquals(expectedThirdValue, sut.dequeue());
    assertEquals(expectedFourthValue, sut.dequeue());
    assertEquals(expectedFifthValue, sut.dequeue());
    assertEquals(expectedSixthValue, sut.dequeue());
    assertEquals(0, sut.count);
  }
}
