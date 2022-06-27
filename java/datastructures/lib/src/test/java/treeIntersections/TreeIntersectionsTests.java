package treeIntersections;

import binaryTreeFindMax.NouveauBinaryNode;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TreeIntersectionsTests {

  private ArrayList<Integer> leftTreeValues = new ArrayList<>();
  private ArrayList<Integer> rightTreeValues = new ArrayList<>();
  private ArrayList<Integer> shortLeftTreeValues = new ArrayList<>();
  private ArrayList<Integer> shortRightTreeValues = new ArrayList<>();

  @Test
  public void testTwoShortTreesIntersectionFindsTwoDupes() {
    
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

  private boolean initializeShorRightValues() {
    rightTreeValues.add(15);
    rightTreeValues.add(100);
    rightTreeValues.add(125);

    return true;
  }
}
