package karyTree;

import org.junit.jupiter.api.Test;

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
    sut.addChild(new KaryNode<String>("childThingy"));
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
    KaryTree<KaryNode<Integer>> sut = new KaryTree<>();
    KaryNode<String> actualResult = sut.fizzBuzzConverter(rootNode);
    assertNull(actualResult, "FizzBuzz method returns null if given an empty node.");
  }

  @Test
  void testTreeWithNoFizzyBuzzyNumbersReturnsTreeWithoutThrowing() {
    KaryNode<Integer> rootNode = new KaryNode<>(1,3);
    rootNode.addChild(new KaryNode<>(2,3));
    rootNode.addChild(new KaryNode<>(4,3));
    rootNode.addChild(new KaryNode<>(7,3));

    KaryTree<String> sut = new KaryTree<>();
    assertDoesNotThrow(()-> {
      sut.fizzBuzzConverter(rootNode);
    });
  }

  @Test
  void testTreeWithFizzyBuzzyNumbersReturnsCorrectSolutionWithoutThrowing() {
    KaryNode<Integer> rootNode = new KaryNode<>(25);
    rootNode.addChild(new KaryNode<>(17, 3));
    rootNode.children.get(0).addChild(new KaryNode<Integer>(15));
    rootNode.children.get(0).addChild(new KaryNode<Integer>(18));
    rootNode.children.get(0).addChild(new KaryNode<Integer>(20, 1));

    rootNode.children.get(0).children.get(2).addChild(new KaryNode<Integer>(21)); // this might be failing

    rootNode.children.add(new KaryNode<Integer>(28));
    rootNode.children.get(1).addChild(new KaryNode<>(26));
    rootNode.children.get(1).addChild(new KaryNode<>(27));

    KaryTree<String> sut = new KaryTree<>();

    assertDoesNotThrow(()-> {
      sut.fizzBuzzConverter(rootNode);
    });
  }

  @Test
  void testSingleFizzNumberNodeReturnsFizz() {
    KaryNode<Integer> rootNode = new KaryNode<>(3);
    KaryTree<String> sut = new KaryTree<>();

    String expectedValue = "Fizz";

    KaryNode<String> resultNode = sut.fizzBuzzConverter(rootNode);

    assertEquals(expectedValue, resultNode.getValue());
  }

  @Test
  void testSingleBuzzNumberRootNodeReturnsBuzz() {
    KaryNode<Integer> rootNode = new KaryNode<>(5);
    KaryTree<String> sut = new KaryTree<>();

    String expectedValue = "Buzz";

    KaryNode<String> resultNode = sut.fizzBuzzConverter(rootNode);

    assertEquals(expectedValue, resultNode.getValue());
  }

  @Test
  void testSingleFizBuzzNumberRootNodeReturnsFizzBuzz() {
    KaryNode<Integer> rootNode = new KaryNode<>(15);
    KaryTree<String> sut = new KaryTree<>();

    String expectedValue = "FizzBuzz";

    KaryNode<String> resultNode = sut.fizzBuzzConverter(rootNode);

    assertEquals(expectedValue, resultNode.getValue());
  }

  @Test
  void testLopsidedTreeStillReturnsProperFizzBuzzResults() {
  }
}
