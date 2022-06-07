package binaryTreeFindMax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeFindMaxPackageTests {

  @Test
  void testCanInstantiateAnEmptyTree() {
    NouveauBinaryTree sut = new NouveauBinaryTree();
    assertTrue(sut.isEmpty());
  }

  @Test
  void testCanSuccessfullyInstantiateTreeWithSingleRootNode() {
    NouveauBinaryNode<Integer> rootNode = new NouveauBinaryNode<>(11);
    NouveauBinaryTree sut = new NouveauBinaryTree(rootNode);
    assertEquals(false, sut.isEmpty());
  }
}
