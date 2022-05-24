package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String expectedResult = "[42]->NULL";
    String actualResult = sut.toString();
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);
    assertEquals(expectedResult, actualResult, "LinkedList with single Node.value=42 to string returns \"[42]\"->");
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

    String expectedResult = "[42]->[11]->[-7]->[123]->[999999999]->NULL";
    String actualResult = sut.toString();

    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Can return collection of values in linked list.");
  }

  @Test
  void testCanAppendNodeWithNewValueToEndOfLinkedList() {
    int valueOfNewNode = 5150;
    int expectedCount = 5;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int actualCount = sut.count;
    assertEquals(expectedCount, actualCount, "LinkedList should have 5 Nodes.");

    boolean expectedAppendResult = true;
    boolean actualAppendReturn = sut.append(valueOfNewNode);

    expectedCount++;
    actualCount = sut.count;
    assertEquals(expectedCount, actualCount,"New Node addition increments LL Count property.");

    boolean actualFoundNode = sut.includes(valueOfNewNode);
    assertTrue(actualFoundNode, "LL.includes method finds node with value after append method called.");

    // use regex to find the actual node at the end of the list via toString() method
    // there are probably better ways to do this, but it gets the job done at this level
    String myPattern = "\\[5150]->NULL$";
    Pattern pattern = Pattern.compile(myPattern, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sut.toString());
    boolean matchFound = matcher.find();

    assertTrue(matchFound, "regex finds newly insert node at end of the list via toString().");
    assertEquals(expectedAppendResult, actualAppendReturn,"Append method returns True when succeeds.");
  }

  @Test
  void testInsertBeforeFoundNodeWithNewNode() {
    int valueOfNewNode = 5150;
    int expectedCount = 5;
    int nodeValue = -7;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(nodeValue);
    sut.insert(11);
    sut.insert(42);

    int actualCount = sut.count;
    assertEquals(expectedCount, actualCount, "LinkedList should have 5 Nodes.");

    boolean expectedInsertBeforeReturn = true;
    boolean actualInsertBeforeReturn = sut.insertBefore(nodeValue, valueOfNewNode);

    expectedCount++;
    actualCount = sut.count;
    assertEquals(expectedCount, actualCount, "New Node addition increments LL Count property.");

    boolean actualFoundNode = sut.includes(valueOfNewNode);
    assertTrue(actualFoundNode, "LL.includes method finds node with value after append method called.");

    // use regex to find the actual node at the end of the list via toString() method
    // there are probably better ways to do this, but it gets the job done at this level
    String myPattern = "\\[11]->\\[5150]->\\[-7]->";
    Pattern pattern = Pattern.compile(myPattern, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sut.toString());
    boolean matchFound = matcher.find();

    assertTrue(matchFound, "regex finds newly inserted node at end of the list via toString().");
    assertEquals(expectedInsertBeforeReturn, actualInsertBeforeReturn,
      "InsertBefore method returns True when succeeds.");
  }

  @Test
  void testInsertAfterFoundNodeWithNewNode() {
    int valueOfNewNode = 5150;
    int expectedCount = 5;
    int nodeValue = 123;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(nodeValue);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int actualCount = sut.count;
    assertEquals(expectedCount, actualCount, "LinkedList should have 5 Nodes.");

    boolean expectedInsertBeforeReturn = true;
    boolean actualInsertBeforeReturn = sut.insertAfter(nodeValue, valueOfNewNode);

    expectedCount++;
    actualCount = sut.count;
    assertEquals(expectedCount, actualCount, "New Node addition increments LL Count property.");

    boolean actualFoundNode = sut.includes(valueOfNewNode);
    assertTrue(actualFoundNode, "LL.includes method finds node with value after append method called.");

    // use regex to find the actual node at the end of the list via toString() method
    // there are probably better ways to do this, but it gets the job done at this level
    String myPattern = "\\[123]->\\[5150]->\\[999999999]->";
    Pattern pattern = Pattern.compile(myPattern, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(sut.toString());
    boolean matchFound = matcher.find();

    assertTrue(matchFound, "regex finds newly inserted node at end of the list via toString().");
    assertEquals(expectedInsertBeforeReturn, actualInsertBeforeReturn,
      "InsertBefore method returns True when succeeds.");
  }

  @Test void testWhereKIsGreaterThanLengthOfLinkedListThrows() {
    int expectedCount = 5;
    int testInput = 15;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

    assertThrows(IndexOutOfBoundsException.class, () -> sut.getKthNodeFromEndValue(testInput),
      "Asking for kth that is larger than Linked List node count results in ArrayIndexOutOfBoundsException.");
  }

  @Test void testWhereKIsNegativeIntegerThrows() {
    int expectedCount = 5;
    int testInput = -1;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

    assertThrows(IndexOutOfBoundsException.class, () -> sut.getKthNodeFromEndValue(testInput),
      "Asking for kth that is a negative number results in ArrayIndexOutOfBoundsException.");
  }

}
