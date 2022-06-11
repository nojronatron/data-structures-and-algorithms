package karyTree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class karyTreePackageTests {
  @Test
  void testCanInstantiateKaryNodeWithoutValue() {
    KaryNode<Integer> sut = new KaryNode<>();
    assertTrue(sut.isEmpty());
  }

  @Test
  void testNoChildrenCheckDoesNotThrow(){
    KaryNode<String> sut = new KaryNode<>("25");
    assertDoesNotThrow( ()-> {sut.getChildren();});
    assertNull(sut.getChildren());
  }

  @Test
  void testCanAddNodeAsChild(){
    KaryNode<String> sut = new KaryNode<>("thingy");
    sut.addNode(new KaryNode<String>("childThingy"));
    assertTrue(sut.hasChildren());
  }

  @Test
  void testChildrenCheckReturnsCurrentNumChildren(){

  }

  @Test
  void testCanOnlyAdd3ChildrenInK3Node(){

  }

  @Test
  void testEmptyInputReturnsNullOutput() {
    KaryNode<Integer> rootNode = new KaryNode<>();
    KaryTree<KaryNode<Integer>> sut = new KaryTree<>(rootNode);

    KaryNode<String> actualResult = sut.FizzBuzz(sut);

    assertNull(actualResult, "FizzBuzz method returns null if given an empty node.");
  }

  @Test
  void testTreeWithNoFizzyBuzzyNumbersReturnsTreeWithoutThrowing() {
    KaryNode<Integer> rootNode = new KaryNode<>(25);
    rootNode.addNode(new KaryNode<Integer>(17, 3));
    rootNode.children.get(0).addNode(new KaryNode<Integer>(15));
    rootNode.children.get(0).addNode(new KaryNode<Integer>(18));
    rootNode.children.get(0).addNode(new KaryNode<Integer>(20));
    rootNode.children.get(0).children.get(0).addNode(new KaryNode<Integer>(21)); // this might be failing
    rootNode.children.add(new KaryNode<Integer>(28));
    rootNode.children.get(1).addNode(new KaryNode<>(26));
    rootNode.children.get(1).addNode(new KaryNode<>(27));

    System.out.println(rootNode.getValue().toString());

//    ArrayList<KaryNode<Integer>> childrenAtLevel3 = new ArrayList<>();
//    childrenAtLevel3.add(new KaryNode<>(21));
//
//    ArrayList<KaryNode<Integer>> childrenAtLevel2Alpha = new ArrayList<>();
//    childrenAtLevel2Alpha.add(new KaryNode<>(15));
//    childrenAtLevel2Alpha.add(new KaryNode<>(18));
//    childrenAtLevel2Alpha.add(new KaryNode<>(20));
//
//    ArrayList<KaryNode<Integer>> childrenAtLevel2Bravo = new ArrayList<>();
//    childrenAtLevel2Bravo.add(new KaryNode<>(26));
//    childrenAtLevel2Bravo.add(new KaryNode<>(27));
//
//    ArrayList<KaryNode<Integer>> childrenAtLevel1 = new ArrayList<>();
//    childrenAtLevel1.add(new KaryNode<>(17));
//    childrenAtLevel1.add(new KaryNode<>(28));
//
//    childrenAtLevel2Alpha.get(2).setChildren(childrenAtLevel3);
//    childrenAtLevel1.get(0).setChildren(childrenAtLevel2Alpha);
//    childrenAtLevel1.get(1).setChildren(childrenAtLevel2Bravo);
//    rootNode.setChildren(childrenAtLevel1);
//
//    KaryTree<KaryNode<Integer>> sut = new KaryTree<>(rootNode);
//
//    KaryNode<String> actualResult = null;
//    actualResult = sut.FizzBuzz(sut);
//
//    assertNotNull(actualResult.getChildren());
//    assertEquals(2, actualResult.getChildren().size());
  }

  @Test
  void testTreeWithOnlyFizzyBuzzyNumbersReturnsCorrectSolutionWithoutThrowing() {
  }

  @Test
  void testSingleFizzNumberNodeReturnsFizz() {
  }

  @Test
  void testSingleBuzzNumberRootNodeReturnsBuzz() {
  }

  @Test
  void testSingleFizBuzzNumberRootNodeReturnsFizzBuzz() {
  }

  @Test
  void testLopsidedTreeStillReturnsProperFizzBuzzResults() {
  }
}
