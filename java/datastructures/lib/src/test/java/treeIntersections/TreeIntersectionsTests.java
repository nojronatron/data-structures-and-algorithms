package treeIntersections;

import binaryTreeFindMax.NouveauBinaryNode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class TreeIntersectionsTests {

  private ArrayList<Integer> leftTreeValues = new ArrayList<>();
  private ArrayList<Integer> rightTreeValues = new ArrayList<>();
  private ArrayList<Integer> shortLeftTreeValues = new ArrayList<>();
  private ArrayList<Integer> shortRightTreeValues = new ArrayList<>();

  @Test
  public void testTreeIntersectionsObjectCanBeInstantiated() {
    TreeIntersections<Integer> sut = new TreeIntersections<>();
    assertNotNull(sut);
  }

  @Test
  public void testTwoShortTreesIntersectionFindsTwoDupes() {
    ArrayList<Integer> expectedDuplicates = new ArrayList<>();
    expectedDuplicates.add(100);
    expectedDuplicates.add(125);
    int expectedSize = 2;

    TreeIntersections<Integer> sut = new TreeIntersections<>();
    NouveauBinaryNode<Integer> leftTree = initializeShortLeftRoot();
    NouveauBinaryNode<Integer> rightTree = initializeShortRightRoot();

    ArrayList<Integer> actualResult = sut.tree_intersection(leftTree, rightTree);
    int actualSize = actualResult.size();

    for(Integer result: actualResult) {
      assertTrue( expectedDuplicates.contains(result), "Expected items should be in the resulting collection.");
    }
    
    assertEquals(expectedSize, actualSize, "Output and expected array lengths should be equal.");
  }

  private boolean initializeLeftValues() {
    leftTreeValues.add(75);
    leftTreeValues.add(100);
    leftTreeValues.add(125);
    leftTreeValues.add(160);
    leftTreeValues.add(175);
    leftTreeValues.add(150);
    leftTreeValues.add(200);
    leftTreeValues.add(250);
    leftTreeValues.add(300);
    leftTreeValues.add(350);
    leftTreeValues.add(500);

    return true;
  }

  private boolean initializeRightValues() {
    rightTreeValues.add(15);
    rightTreeValues.add(100);
    rightTreeValues.add(125);
    rightTreeValues.add(160);
    rightTreeValues.add(175);
    rightTreeValues.add(42);
    rightTreeValues.add(200);
    rightTreeValues.add(600);
    rightTreeValues.add(4);
    rightTreeValues.add(350);
    rightTreeValues.add(500);

    return true;
  }

  private boolean initializeShortLeftValues() {
    leftTreeValues.add(75);
    leftTreeValues.add(100);
    leftTreeValues.add(125);

    return true;
  }

  private boolean initializeShortRightValues() {
    rightTreeValues.add(15);
    rightTreeValues.add(100);
    rightTreeValues.add(125);

    return true;
  }

  private NouveauBinaryNode<Integer> initializeShortLeftRoot() {
    if(initializeShortLeftValues()) {
      NouveauBinaryNode<Integer> node = new NouveauBinaryNode<>(leftTreeValues.get(1));
      node.setLeft(new NouveauBinaryNode<>(leftTreeValues.get(0)));
      node.setRight(new NouveauBinaryNode<>(leftTreeValues.get(2)));
      return node;
    }

    return null;
  }

  private NouveauBinaryNode<Integer> initializeShortRightRoot() {
    if (initializeShortRightValues()) {
      NouveauBinaryNode<Integer> node = new NouveauBinaryNode<>(rightTreeValues.get(1));
      node.setLeft(new NouveauBinaryNode<>(rightTreeValues.get(0)));
      node.setRight(new NouveauBinaryNode<>(rightTreeValues.get(2)));
      return node;
    }

    return null;
  }

}
