package datastructures.linkedlist;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.LinkedListNode;
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
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);
    assertTrue(false);
  }

  @Test
  void testCanInsertMultipleNodesIntoLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut.toString());
    assertTrue(false);
  }

  @Test
  void testReturnsTrueIfValueFoundInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);
    Boolean actualResult = sut.includes(42);
    Boolean expectedResult = true;
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);
    assertEquals(expectedResult, actualResult);
  }

  @Test
  void testReturnFalseWhenNotContainsSearchValue() {
    LinkedList sut = new LinkedList();

    Boolean actualResult = sut.includes(42);
    Boolean expectedResult = false;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult);
  }

  @Test
  void testCanReturnCollectionOfValuesInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int expectedCount = 5;
    int actualCount = sut.count;
    String expectedResult = "[42]=>[11]=>[-7]=>[123]=>[999999999]";
    String actualResult = sut.toString();

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedCount, actualCount, "LinkedList count instance method should maintain accurate count");
    assertEquals(expectedResult, actualResult, "LinkedList with single Node.value=42 to string returns \"[42]\"");
  }
}
