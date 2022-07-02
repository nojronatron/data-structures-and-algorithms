package myGraphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyGraphs {

  @Test
  public void testNodeSuccessfullyAddedToGraph() {

  }

  @Test
  public void testEdgeSuccessfullyAddedToGraph() {

  }

  @Test
  public void testCollectionOfAllNodesCanBeRetrievedFromGraph() {

  }

  @Test
  public void testAllAppropriateNeighborsCanBeRetrievedFromGraph() {

  }

  @Test
  public void testNeighborsAreReturnedWithWeightBetweenNodesIncluded() {

  }

  @Test
  public void testProperSizeIsReturnedRepresentingNumberOfVerticesInGraph() {

  }

  @Test
  public void testGraphWithOnlyOneNodeAndEdgeCanBeReturned() {

  }

  @Test
  public void testAnEmptyGraphProperlyReturnsNull() {
    int expectedBucketsCount = 0;
    int expectedVerticesCount = 0;

    Graph<Integer> sut = new Graph<>();

    ArrayList<Vertex<Integer>> actualListOfNodes = sut.getNodes();
    assertEquals(null, actualListOfNodes,
      "getNodes() should return null for initialized, empty Graph.");

    int actualBucketsCount = sut.getBucketsCount();
    assertEquals(expectedBucketsCount, actualBucketsCount,"Default buckets count should be 17.");

    int actualVerticesCount = sut.getVerticesCount();
    assertEquals(expectedVerticesCount, actualVerticesCount,
      "Actual vertices count should be zero as none have been added.");
  }
}
