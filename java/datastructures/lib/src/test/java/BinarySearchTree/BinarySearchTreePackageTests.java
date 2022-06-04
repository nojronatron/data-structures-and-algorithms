package BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreePackageTests {
  @Test
  void testCanInstantiateTreeWithSingleRootNode()
  {
    BinarySearchTree sut = new BinarySearchTree(11);
    boolean actualResult = sut.getHasRootNode();
    assertTrue(actualResult);
  }
}
