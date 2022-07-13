package binarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreePackageTests {
  @Test
  void testCanInstantiateAnEmptyTree()
  {
    BinarySearchTree sut = new BinarySearchTree();
    assertEquals(0, sut.getCount());
  }

  @Test
  void testCanSuccessfullyInstantiateTreeWithSingleRootNode() {
    BinarySearchTree sut = new BinarySearchTree(11);
    assertTrue(sut.getHasRootNode());
    int actualGetCount = sut.getCount();
    assertEquals(1, actualGetCount);
  }

  @Test
  void testBinarySearchTreeCanAddLeftChildAndRightChildToNode() {
    int expectedRootLeftValue = 10;
    int expectedRootRightValue= 12;
    BinarySearchTree sut = new BinarySearchTree(11);
    assertTrue(sut.getHasRootNode(), "BST should have a root node when instantiated with a value.");
    sut.addUsingBFS(10);
    assertEquals(2, sut.getCount(), "BST should have 2 nodes after Add is called.");
    sut.addUsingBFS(12);
    assertEquals(3, sut.getCount(), "BST should have 3 nodes after Add is called a second time.");
    assertEquals(sut.root.left.value, expectedRootLeftValue,
      "BST Root node left child should have the value sent with first Add method call.");
    assertEquals(sut.root.right.value, expectedRootRightValue,
      "BST Root node right child should have the value sent with the second Add method call.");
  }

  @Test
  void testCanReturnCollectionFromInorderTraversal() {
    int[] expectedResult = new int[]{ 4, 2, 5, 1, 6, 3, 7 };
    BinarySearchTree sut = new BinarySearchTree();
    sut.addUsingBFS(1);
    sut.addUsingBFS(2);
    sut.addUsingBFS(3);
    sut.addUsingBFS(4);
    sut.addUsingBFS(5);
    sut.addUsingBFS(6);
    sut.addUsingBFS(7);

//    var actualResult = sut.toString("in");
//    System.out.println("Actual in order result: " + actualResult);
//    assertEquals(expectedResult,actualResult)
  }

  @Test
  void testCanReturnCollectionFromPreorderTraversal() {
    int[] expectedResult = new int[]{ 1, 2, 4, 5, 3, 6, 7 };
    BinarySearchTree sut = new BinarySearchTree();
    sut.addUsingBFS(1);
    sut.addUsingBFS(2);
    sut.addUsingBFS(3);
    sut.addUsingBFS(4);
    sut.addUsingBFS(5);
    sut.addUsingBFS(6);
    sut.addUsingBFS(7);

//    var actualResult = sut.toString("pre");
//    System.out.println("Actual pre order result: " + actualResult);
//    assertEquals(expectedResult,actualResult);
  }

  @Test
  void testCanReturnCollectionFromPostorderTraversal() {
    int[] expectedResult = new int[]{ 4, 5, 2, 6, 7, 3, 1 };
    BinarySearchTree sut = new BinarySearchTree();
    sut.addUsingBFS(1);
    sut.addUsingBFS(2);
    sut.addUsingBFS(3);
    sut.addUsingBFS(4);
    sut.addUsingBFS(5);
    sut.addUsingBFS(6);
    sut.addUsingBFS(7);

//    var actualResult = sut.toString("post");
//    System.out.println("Actual post order result: " + actualResult);
//    assertEquals(expectedResult,actualResult);
  }

}
