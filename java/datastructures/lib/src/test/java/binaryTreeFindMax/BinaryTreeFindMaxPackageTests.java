package binaryTreeFindMax;

import org.junit.jupiter.api.Test;

import javax.xml.stream.FactoryConfigurationError;
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
    // load up a bunch of values into a tree 2, 7, 5, 2, 6, 9, 5, 11, 4
    ArrayList<Integer> expectedOutputArray = new ArrayList<>(Arrays.asList(2, 7, 5, 2, 6, 9, 5, 11, 4));
    var expectedArraySize = expectedOutputArray.size();
    NouveauBinaryNode<Integer> inputTreeRoot = new NouveauBinaryNode<>(2);

    // 2nd row
    inputTreeRoot.setLeft(new NouveauBinaryNode<>(7));
    inputTreeRoot.setRight(new NouveauBinaryNode<>(5));

    // 3rd row
    inputTreeRoot.getLeft().setLeft(new NouveauBinaryNode<>(2));
    inputTreeRoot.getLeft().setRight(new NouveauBinaryNode<>(6));
    inputTreeRoot.getRight().setRight(new NouveauBinaryNode<>(9));

    // fourth row
    inputTreeRoot.getLeft().getRight().setLeft(new NouveauBinaryNode<>(5));
    inputTreeRoot.getLeft().getRight().setRight(new NouveauBinaryNode<>(11));
    inputTreeRoot.getRight().getRight().setLeft(new NouveauBinaryNode<>(4));

    //  instantiate the sut
    var sut = new NouveauBinaryTree<Integer>();

    ArrayList<Integer> actualResult = sut.getBreadthFirst(inputTreeRoot);

    assertEquals(expectedArraySize, actualResult.size());

    for(int idx=0; idx < expectedArraySize; idx++) {
      assertEquals(expectedOutputArray.get(idx), actualResult.get(idx),
        "Array elements should be in correct order.");
    }

    assertTrue(true);
  }

  @Test
  void testBreadthFirstExpectedFailure() {
    ArrayList<Integer> expectedResult = null;
    NouveauBinaryTree<Integer> actualResult = new NouveauBinaryTree<>();
    assertNotEquals(expectedResult, actualResult);
  }

  @Test
  void testBreadthInputTreeNull() {
    ArrayList<Integer> expectedResult = null;
    NouveauBinaryNode<Integer> nullBinaryNode = new NouveauBinaryNode<>();
    var sut = new NouveauBinaryTree<>();

    assertTrue(sut.isEmpty());
    assertEquals(expectedResult, sut.getBreadthFirst(nullBinaryNode),
      "GetBreadthFirst returns [null] on empty tree.");
  }

  @Test
  void testBreadthFirstAllLeftTree() {
    var expectedSize = bulkLoadValuesBig11.size() + 1;

    NouveauBinaryNode<Integer> bigRoot = new NouveauBinaryNode<>(1);
    NouveauBinaryNode<Integer> temp = bigRoot;

    for(Integer item: bulkLoadValuesBig11) {
        temp.setLeft(new NouveauBinaryNode<>(item));
        temp = temp.getLeft();
    }

    System.out.println("Tree is now full? " + bigRoot.getValue());

    var sut = new NouveauBinaryTree<>();
    var actualResult = sut.getBreadthFirst(bigRoot);
    var actualSize = actualResult.size();

    assertEquals(expectedSize, actualSize);;
    var expectedOutputArray = new ArrayList<Integer>();
    expectedOutputArray.add(1);
    expectedOutputArray.addAll(bulkLoadValuesBig11);

    for(int idx=0; idx < expectedSize; idx++) {
      assertEquals(expectedOutputArray.get(idx), actualResult.get(idx),
        "Array elements should be in correct order.");
    }

    assertTrue(true);
  }

  @Test
  void testBreadthFirstYetAnotherCase() {
  }
}
