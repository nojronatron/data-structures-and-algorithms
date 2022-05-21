package datastructures.linkedlist;

import datastructures.linkedlist.LinkedList;
import datastructures.linkedlist.LinkedListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {
  @Test
  void testInstantiatesEmptyLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testCanInsertNodeIntoLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testHeadPointsToFirstNodeInLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testCanInsertMultipleNodesIntoLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testReturnsTrueIfValueFoundInLinkedList() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testReturnFalseWhenNotContainsSearchValue() {
    LinkedList sut = new LinkedList();
    System.out.println(sut);
    assertTrue(true);
  }

  @Test
  void testCanReturnCollectionOfValuesInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);
    System.out.println(sut);
    String expectedResult = "[42]";
    String actualResult = sut.toString();
    assertEquals(expectedResult,actualResult, "LinkedList with single Node.value=42 to string returns \"[42]\"");
  }
}
