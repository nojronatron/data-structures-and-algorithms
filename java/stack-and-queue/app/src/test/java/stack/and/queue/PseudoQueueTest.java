package stack.and.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PseudoQueueTest {
  @Test
  void testInstantiatingNewPseudoQueueDoesNotThrow() {
    assertDoesNotThrow(()-> {
      PseudoQueue<Integer> sut = new PseudoQueue<>();
    });
  }

  @Test
  void testCallingDequeueOnEmptyPseudoQueueReturnsNull() {
    // expected result = NULL
    PseudoQueue<Integer> sut = new PseudoQueue<>();
    assertNull(sut.dequeue());
  }

  @Test
  void testCallingEnqueueOnEmptyPseudoQueueIncrementsCount() {
    int expectedCountResult = 1;

    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(3);

    int actualCountResult = sut.count;

    assertEquals(expectedCountResult, actualCountResult, "Calling enqueue on an empty Q increments count.");
  }

  @Test
  void testCallingEnqueueMultipleTimeThenDequeueThenEnqueueAltersCountProperly(){
    int expectedCountResult = 3;
    int expectedFirstDequeueValue = 1;
    int expectedNextDequeueValue = 2;

    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(1);
    sut.enqueue(2);
    sut.enqueue(3);
    int actualFirstDequeueValue = sut.dequeue(); // should deck int=1
    sut.enqueue(2);

    assertEquals(expectedFirstDequeueValue, actualFirstDequeueValue, "Dequeue should return the 1st Enqueued value.");
    assertEquals(expectedCountResult, sut.count, "Count it altered properly through multiple enqueue and dequeue calls.");
    assertEquals(expectedNextDequeueValue, sut.dequeue(), "Correct value is dequeued after enq-deq-enq calls.");
  }

  @Test
  void testCallingQueueFiveTimesThenCallingDequeueFiveTimesReturnsQueuedValuesAndCountDecrementedToZero() {
    int expectedFirstValue = 1;
    int expectedSecondValue = 2;
    int expectedThirdValue = 3;
    int expectedFourthValue = 4;
    int expectedFifthValue = 5;

    PseudoQueue<Integer> sut = new PseudoQueue<>();
    sut.enqueue(expectedFirstValue);
    sut.enqueue(expectedSecondValue);
    sut.enqueue(expectedThirdValue);
    sut.enqueue(expectedFourthValue);
    sut.enqueue(expectedFifthValue);

    assertEquals(5, sut.count);
    int actualFirstValue = sut.dequeue();
    assertEquals(expectedFirstValue, actualFirstValue, "Dequeue should return the 1st Enqueued value.");
    assertEquals(4, sut.count);
    int actualSecondValue = sut.dequeue();
    assertEquals(expectedSecondValue, actualSecondValue, "Dequeue should return the 2nd Enqueued value.");
    assertEquals(3, sut.count);
    int actualThirdValue = sut.dequeue();
    assertEquals(expectedThirdValue, actualThirdValue, "Dequeue should return the 3rd Enqueued value.");
    assertEquals(2, sut.count);
    int actualFourthValue = sut.dequeue();
    assertEquals(expectedFourthValue, actualFourthValue, "Dequeue should return the 4th Enqueued value.");
    assertEquals(1, sut.count);
    int actualFifthValue = sut.dequeue();
    assertEquals(expectedFifthValue, actualFifthValue, "Dequeue should return the 5th Enqueued value.");
    assertEquals(0, sut.count, "PseudoQueue should return count = 0 when all items Dequeued.");
  }
}
