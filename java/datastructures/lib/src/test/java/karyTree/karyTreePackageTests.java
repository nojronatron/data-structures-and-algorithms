package karyTree;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import javax.xml.stream.FactoryConfigurationError;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class karyTreePackageTests {
  @Test
  void testCanInstantiateKaryTree() {
    KaryTree<karyNode<Integer>> sut = new KaryTree<>();
    assertTrue(sut.isEmpty());
  }

  @Test
  void testEmptyInputReturnsNullOutput() {
  }

  @Test
  void testTreeWithNoFizzyBuzzyNumbersReturnsTreeWithoutThrowing() {
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
