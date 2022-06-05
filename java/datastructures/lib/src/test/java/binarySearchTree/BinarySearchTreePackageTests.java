package binarySearchTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

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
    sut.add(10);
    assertEquals(2, sut.getCount(), "BST should have 2 nodes after Add is called.");
    sut.add(12);
    assertEquals(3, sut.getCount(), "BST should have 3 nodes after Add is called a second time.");
    assertEquals(sut.root.left.value, expectedRootLeftValue,
      "BST Root node left child should have the value sent with first Add method call.");
    assertEquals(sut.root.right.value, expectedRootRightValue,
      "BST Root node right child should have the value sent with the second Add method call.");
  }

  @Test
  void testCanReturnCollectionFromInorderTraversal() {
    int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7};
    BinarySearchTree sut = new BinarySearchTree();
    sut.add(1);
    sut.add(2);
    sut.add(3);
    sut.add(4);
    sut.add(5);
    sut.add(6);
    sut.add(7);

    var actualResult = sut.toString("in");
    System.out.println("Actual in order result: " + actualResult);
    assertEquals(expectedResult,actualResult);
  }
}
