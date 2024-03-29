package binaryTreeFindMax;

import binarySearchTree.BinaryNode;
import binarySearchTree.BinarySearchTree;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;

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
    System.out.println("Resulting Nouveau Binary Tree (InOrder): " + sut.toString());
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

    System.out.println("Resulting Nouveau Binary Tree (InOrder): " + sut.toString());

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

    System.out.println("Resulting Nouveau Binary Tree (InOrder): " + sut.toString());

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

    System.out.println("Resulting Nouveau Binary Tree (InOrder): " + sut.toString());

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

    System.out.println("Resulting Nouveau Binary Tree (InOrder): " + sut.toString());

    assertTrue(true);
  }

  @Test
  void test_BinarySearchTree_CanAddNodesAndSortThemIntoTree() {

    int rootValue = 50;
    int firstLeftChild = 40;
    int firstRightChild = 60;

    BinarySearchTree bst = new BinarySearchTree(rootValue);
    var firstAddedNode = bst.add(firstLeftChild);
    var secondAddedNode = bst.add(firstRightChild);

    System.out.println("Resulting Binary Search Tree (InOrder): " + bst.toString());

    assertNotNull(firstAddedNode, "Add with valid input should not return a null Node.");
    assertNotNull(secondAddedNode, "Add with valid input should not return a null Node.");
    assertEquals(3, bst.getCount(), "There should be 3 Binary Nodes in the tree now.");
  }

  @Test
  void test_BinarySearchTree_CanAddManyNodesAndSortThemIntoTree() {
    int expectedCount = 11;
    int rootValue = 50;
    ArrayList<Integer> inputValues = new ArrayList<>(Arrays.asList(rootValue, 40,60,30,45,55,70,20,43,65,67));

    BinarySearchTree bst = new BinarySearchTree();
    assertEquals(0, bst.getCount(),
      "Instantiating a BST with a single value adds a single Node (root).");

    int addCounter = 0;

    for(int val: inputValues) {
      assertNotNull(bst.add(val));
      addCounter++;
    }

    System.out.println("Resulting Binary Search Tree (InOrder): " + bst.toString());

    assertEquals(expectedCount, addCounter,
      "Add Node should add 10 more nodes to the BST without returning Null.");
    assertEquals(expectedCount, bst.getCount(), "BST Count should be 11.");
  }

  @Test
  void test_BinarySearchTree_ContainsFindsExistingValuesUsingDFS() {
    int searchValue = 65;
    boolean expectedResult = true;
    int rootValue = 50;
    ArrayList<Integer> inputValues = new ArrayList<>(Arrays.asList(40,60,30,45,55,70,20,43,65,67));

    BinarySearchTree bst = new BinarySearchTree();
    BinaryNode rootNode = bst.add(rootValue);

    for(int val: inputValues) {
      assertNotNull(bst.add(val));
    }

    boolean actualResult = bst.contains(searchValue);

    System.out.println("Resulting Binary Search Tree (InOrder): " + bst.toString());

    assertEquals(expectedResult, actualResult,
      "Node with value 65 is contained within this BST.");
  }

  @Test
  void test_BinarySearchTree_AddUsingBfsActuallyAddsNodes() {
    int expectedCount = 11;
    int rootValue = 50;
    ArrayList<Integer> inputValues = new ArrayList<>(Arrays.asList(rootValue, 40,60,30,45,55,70,20,43,65,67));

    BinarySearchTree bst = new BinarySearchTree();
    assertEquals(0, bst.getCount(),
      "Instantiating a BST with a single value adds a single Node (root).");

    int addCounter = 0;

    StringBuilder sb = new StringBuilder();
    sb.append("[");

    for(int val: inputValues) {
      bst.addUsingBFS(val);
      addCounter++;
      sb.append(val).append(", ");
    }

    sb.delete(sb.length() - 2, sb.length() - 1);
    sb.append(" ]");

    System.out.println("Input Array: " + sb.toString());
    System.out.println("BST Loaded using BFS: " + bst.toString());

    assertEquals(expectedCount, addCounter,
      "Add Node using BFS should add 10 more nodes to the BST without returning Null.");
    assertEquals(expectedCount, bst.getCount(), "BST Count should be 11 after BFS add technique.");
  }
}
