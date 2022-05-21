package datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
  @Test
  void testInstantiatesEmptyLinkedList() {
    LinkedList sut = new LinkedList();

    Boolean expectedResult = true;
    Boolean actualResult = sut.count == 0;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Newly instantiated LinkedList will have zero Nodes.");
  }

  @Test
  void testCanInsertNodeIntoLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);
    String expectedResult = "[42]";
    String actualResult = sut.toString();
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);
    assertEquals(expectedResult, actualResult, "LinkedList with single Node.value=42 to string returns \"[42]\"");
  }

  @Test
  void testHeadPointsToFirstNodeInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(4320); // H E A D sorta

    Boolean expectedFirstResult = true;
    Boolean actualFirstResult = sut.head.value == 4320;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    sut.insert(111);

    Boolean expectedSecondResult = true;
    Boolean actualSecondResult = sut.head.value == 111;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedFirstResult, actualFirstResult, "Head points to first node in count=1 linked list.");
    assertEquals(expectedSecondResult, actualSecondResult, "Head points to first node in count=2 linked list.");
  }

  @Test
  void testCanInsertMultipleNodesIntoLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int expectedCount = 5;
    int actualCount = sut.count;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedCount, actualCount,
      "Can insert multiple nodes into linked list (count is maintained).");
  }

  @Test
  void testReturnsTrueIfValueFoundInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);

    Boolean expectedResult = true;
    Boolean actualResult = sut.includes(42);

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Returns true if value found in linked list.");
  }

  @Test
  void testResultsFalseWhenValueNotFoundInLinkedList() {
    LinkedList sut = new LinkedList();

    Boolean actualResult = sut.includes(42);
    Boolean expectedResult = false;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Returns false when value NOT found in linked list.");
  }

  @Test
  void testCanReturnCollectionOfValuesInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    String expectedResult = "[42]=>[11]=>[-7]=>[123]=>[999999999]";
    String actualResult = sut.toString();

    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Can return collection of values in linked list.");
  }
}
