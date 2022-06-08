package binaryTreeFindMax;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeFindMaxPackageTests {

  static NouveauBinaryTree<Integer> batchTree;

  // the arrays.aslist() suggestion came from https://stackoverflow.com/questions/10477628/arraylist-of-int-array-in-java
  static ArrayList<Integer> bulkLoadValues15 = new ArrayList<>(Arrays.asList(1, 7, 6, 5, 11, 2, 5, 2, 9, 4));
  static ArrayList<Integer> bulkLoadValues16 = new ArrayList<>(Arrays.asList(2, 7, 5, 2, 6, 9, 5, 11, 4));
  static ArrayList<Integer> bulkLoadValuesBig11 = new ArrayList<>(Arrays.asList(
    11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
    11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11,
    11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11));

  @Test
  void testFindMaxCanInstantiateAnEmptyTree() {
    NouveauBinaryTree sut = new NouveauBinaryTree();
    assertTrue(sut.isEmpty());
    assertTrue(sut != null);
  }

  @Test
  void testFindMaxCanSuccessfullyInstantiateTreeWithSingleRootNode() {
    NouveauBinaryNode<Integer> rootNode = new NouveauBinaryNode<>(11);
    NouveauBinaryTree sut = new NouveauBinaryTree(rootNode);
    assertEquals(false, sut.isEmpty());
  }

  @Test
  void testFindMaxHappyPath() {
    // test should find the maxvalue in a tree (see sample input in Code Challenge assignment)
    int expectedResult = 11; // maxval in bulkLoadValues15 is 11
    NouveauBinaryTree<NouveauBinaryNode<Integer>> sut = new NouveauBinaryTree<>();

    assertTrue(sut.bulkLoadTree(bulkLoadValues15));

    int actualResult = sut.findMax();

    assertEquals(expectedResult, actualResult, "max val in bulkloadvalues15 should be 11.");
  }

  @Test
  void testFindMaxAnExpectedFailure() {
    // an empty tree should not find a max value
    NouveauBinaryTree<Integer> sut = new NouveauBinaryTree<>();
    assertNull(sut.findMax());
  }

  @Test
  void testFindMaxEdgeCaseOne() {
    // long list of the same numbers returns an individual integer that is max
    int expectedResult = 11; // maxval in bulkLoadValuesBig11 is 11
    NouveauBinaryTree<NouveauBinaryNode<Integer>> sut = new NouveauBinaryTree<>();

    assertTrue(sut.bulkLoadTree(bulkLoadValuesBig11));

    int actualResult = sut.findMax();

    assertEquals(expectedResult, actualResult, "max val in bulkloadvalues15 should be 11.");

  }

  @Test
  void testBreadthFirstHappyPath() {
  }

  @Test
  void testBreadthFirstExpectedFailure() {
  }

  @Test
  void testBreadthFirstEdgeCase() {
  }

  @Test
  void testBreadthFirstAnotherCase() {
  }

  @Test
  void testBreadthFirstYetAnotherCase() {
  }
}
