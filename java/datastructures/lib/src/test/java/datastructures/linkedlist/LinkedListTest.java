package datastructures.linkedlist;

import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

  @Test
  void test_Pop_HeadOffList() {
   LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    assertEquals(42, (int) sut.head.value);

    LinkedListNode poppedNode = sut.pop();

    assertEquals(42, (int) poppedNode.value);
    assertEquals(11, (int) sut.head.value);
  }

  @Test
  void test_Zip_TwoLinkedListsEqualSizes() {
    int expectedFinalCount = 10;

    LinkedList leftList = new LinkedList();
    leftList.append(1);
    leftList.append(3);
    leftList.append(5);
    leftList.append(7);
    leftList.append(9);

    System.out.println("LeftList: " + leftList.toString());

    LinkedList rightList = new LinkedList();
    rightList.append(2);
    rightList.append(4);
    rightList.append(6);
    rightList.append(8);
    rightList.append(10);

    System.out.println("RightList: " + rightList.toString());

    LinkedList sut = LinkedList.zip(leftList, rightList);

    System.out.println("SUT Result: " + sut.toString());

    assertEquals(expectedFinalCount, sut.count,
      "Zipped list Node count should be sum of input list Node counts.");
  }

  @Test
  void test_Zip_TwoLinkedListsShortRightList() {
    int expectedFinalCount = 10;

    LinkedList leftList = new LinkedList();
    leftList.append(1);
    leftList.append(3);
    leftList.append(5);
    leftList.append(7);
    leftList.append(9);
    leftList.append(10);

    System.out.println("LeftList: " + leftList.toString());

    LinkedList rightList = new LinkedList();
    rightList.append(2);
    rightList.append(4);
    rightList.append(6);
    rightList.append(8);

    System.out.println("RightList: " + rightList.toString());

    LinkedList sut = LinkedList.zip(leftList, rightList);

    System.out.println("SUT Result: " + sut.toString());

    assertEquals(expectedFinalCount, sut.count,
      "Zipped list Node count should be sum of input list Node counts.");
  }


  @Test
  void test_Zip_TwoLinkedListsShortLeftList() {
    int expectedFinalCount = 10;

    LinkedList leftList = new LinkedList();
    leftList.append(1);
    leftList.append(3);
    leftList.append(5);
    leftList.append(7);

    System.out.println("LeftList: " + leftList.toString());

    LinkedList rightList = new LinkedList();
    rightList.append(2);
    rightList.append(4);
    rightList.append(6);
    rightList.append(8);
    rightList.append(9);
    rightList.append(10);

    System.out.println("RightList: " + rightList.toString());

    LinkedList sut = LinkedList.zip(leftList, rightList);

    System.out.println("SUT Result: " + sut.toString());

    assertEquals(expectedFinalCount, sut.count,
      "Zipped list Node count should be sum of input list Node counts.");
  }

  @Test
  void test_CTOR_InstantiatesEmptyLinkedList() {
    LinkedList sut = new LinkedList();

    Boolean expectedResult = true;
    Boolean actualResult = sut.count == 0;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Newly instantiated LinkedList will have zero Nodes.");
  }

  @Test
  void test_Insert_CanInsertNodeIntoLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);
    String expectedResult = "[42]->NULL";
    String actualResult = sut.toString();
    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);
    assertEquals(expectedResult, actualResult, "LinkedList with single Node.value=42 to string returns \"[42]\"->");
  }

  @Test
  void test_Head_PointsToFirstNodeInLinkedList() {
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
  void test_Insert_MultipleNodesIntoLinkedList() {
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
  void test_Includes_ReturnsTrueIfValueIsIncludedInLinkedList() {
    LinkedList sut = new LinkedList();
    sut.insert(42);

    Boolean expectedResult = true;
    Boolean actualResult = sut.includes(42);

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Returns true if value found in linked list.");
  }

  @Test
  void test_Find_ReturnsNodeIfFoundInLinkedList() {
    int expectedValue = 30;

    LinkedList sut = new LinkedList();
    sut.insert(10);
    sut.insert(20);
    sut.insert(30);
    sut.insert(-10);
    sut.insert(-20);
    sut.insert(50);

    LinkedListNode foundNode = sut.find(30);

    System.out.println("LL To String: " + sut);

    assertEquals(expectedValue, foundNode.value,
      "Found Node should have value searched for.");
  }

  @Test
  void test_Find_ReturnsNullIfValueNotFoundInLinkedList() {
    int searchValue = 31;

    LinkedList sut = new LinkedList();
    sut.insert(10);
    sut.insert(20);
    sut.insert(30);
    sut.insert(-10);
    sut.insert(-20);
    sut.insert(50);

    LinkedListNode foundNode = sut.find(searchValue);

    System.out.println("LL To String: " + sut);

    assertNull(foundNode,"Found Node should be Null when value searched for not in linked list.");
  }

  @Test
  void test_InsertAfter_AddsNodeAfterNodeWithTargetedValue() {
    int searchValue = 30;
    int valueToInsert = 47;

    LinkedList sut = new LinkedList();
    sut.insert(10);
    sut.insert(20);
    sut.insert(30);
    sut.insert(-10);
    sut.insert(-20);
    sut.insert(50);

    System.out.println("LL To String Before: " + sut.toString());

    assertTrue(sut.insertAfter(searchValue, valueToInsert), "Call to insertAfter should return true.");

    System.out.println("LL To String After: " + sut);

    String expectedResult = "[50]->[-20]->[-10]->[30]->[47]->[20]->[10]->NULL";

    assertEquals(expectedResult, sut.toString(), "update this test");
  }

  @Test
  void test_Includes_ReturnsFalseWhenValueNotFoundInLinkedList() {
    LinkedList sut = new LinkedList();

    Boolean actualResult = sut.includes(42);
    Boolean expectedResult = false;

    System.out.println("LL Node Count: " + sut.count);
    System.out.println("LL To String: " + sut);

    assertEquals(expectedResult, actualResult, "Returns false when value NOT found in linked list.");
  }

  @Test
  void test_ToString_CanReturnCollectionOfValuesInLinkedList() {
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
  void test_Append_NodeWithNewValueToEndOfLinkedList() {
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
  void test_InsertBefore_FoundNodeWithNewNode() {
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

    System.out.println("LL To String Before: " + sut.toString());
    boolean expectedInsertBeforeReturn = true;
    boolean actualInsertBeforeReturn = sut.insertBefore(nodeValue, valueOfNewNode);

    System.out.println("LL To String After: " + sut.toString());

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
  void test_InsertAfter_FoundNodeWithNewNode() {
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
    System.out.println("Current sut: " + sut.toString());

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

    System.out.println("Current sut: " + sut.toString());

    assertTrue(matchFound, "regex finds newly inserted node at end of the list via toString().");
    assertEquals(expectedInsertBeforeReturn, actualInsertBeforeReturn,
      "InsertBefore method returns True when succeeds.");
  }

  @Test void test_GetKthNodeFromEnd_WhereKIsGreaterThanLengthOfLinkedListThrows() {
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

  @Test void test_GetKthNodeFromEnd_WhereKIsNegativeIntegerThrows() {
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

 @Test void test_GetKthNodeFromEnd_KZeroReturnsValueOfTailNode() {
    int kthNodeFromEnd = 0;
    int expectedCount = 5;
    int expectedResult = 999_999_999;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int actualTailNodeValue = sut.tail.value;

    assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

    int actualResult = sut.getKthNodeFromEndValue(kthNodeFromEnd);

    assertEquals(expectedResult, actualResult, "Kth Node 0 should return last node.");
    assertEquals(expectedResult, actualTailNodeValue, "Kth Node 0 returns value of Tail node");
 }

 @Test void test_GetKThNodeFromEnd_EqualsLengthOfLLShouldReturnValueOfHeadNode() {
   int expectedCount = 5;
   int expectedResult = 42;
   LinkedList sut = new LinkedList();
   sut.insert(999_999_999);
   sut.insert(123);
   sut.insert(-7);
   sut.insert(11);
   sut.insert(42);

   int kthNodeFromEnd = sut.count - 1; // 0th from end is Tail, 4th from end is Head in 5-count LL
   int actualHeadNodeValue = sut.head.value;

   assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

   int actualResult = sut.getKthNodeFromEndValue(kthNodeFromEnd);

   assertEquals(expectedResult, actualResult, "Kth Node 4 should return first node.");
   assertEquals(expectedResult, actualHeadNodeValue, "Kth Node 4 returns value of Head node");
 }

  @Test
  void test_GetKthNodeFromEnd_KSomewhereInMiddleOfLinkedListReturnsCorrectValue() {
    int expectedCount = 5;
    int expectedResult = -7;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int kthNodeFromEnd = 2; // should return value -7
    int actualHeadNodeValue = sut.head.value;

    assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

    int actualResult = sut.getKthNodeFromEndValue(kthNodeFromEnd);

    assertEquals(expectedResult, actualResult, "2nd Node from end should return value -7.");
  }

  @Test void test_GetKthNodeFromEnd_RevisitKSomewhereInMiddleOfLinkedListReturnsCorrectValue() {
    int expectedCount = 5;
    int expectedResult = 11;
    LinkedList sut = new LinkedList();
    sut.insert(999_999_999);
    sut.insert(123);
    sut.insert(-7);
    sut.insert(11);
    sut.insert(42);

    int kthNodeFromEnd = 3; // should return value 11
    int actualHeadNodeValue = sut.head.value;

    assertEquals(expectedCount, sut.count, "Five nodes exist in this Linked List.");

    int actualResult = sut.getKthNodeFromEndValue(kthNodeFromEnd);

    assertEquals(expectedResult, actualResult, "3nd Node from end should return value 11.");
  }
}
