package myGraphs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    int expectedResultCount = 3;
    int expectedVerticesCount = 3;

    Graph sut = new Graph();
    var node1 = sut.addNode(1);
    var node2 = sut.addNode(2);
    var node3 = sut.addNode(3);

    sut.addEdge(node1, node2);
    sut.addEdge(node1, node3);

    var actualBucketsInAdjacencyList = sut.getBucketsCount();
    var actualVerticesInThisGraph = sut.getVerticesCount();

    assertEquals(expectedVerticesCount, actualBucketsInAdjacencyList);
    assertEquals(expectedResultCount, actualVerticesInThisGraph);
  }

  @Test
  public void testGraphWithOnlyOneNodeAndEdgeCanBeReturned() {
    int expectedResultCount = 1;
    Vertex expectedNode = new Vertex(11);

    Graph sut = new Graph();
    Vertex newNode = sut.addNode(11);
    sut.addEdge(newNode, null);

    var actualResultCollection = sut.getNodes();
    var actualResultNode = actualResultCollection.get(0);
    var actualResultCount = (long) actualResultCollection.size();
    var actualResultEdgeCount = (long) actualResultNode.getEdges().size();

    assertEquals(expectedNode.getValue(), actualResultNode.getValue(),
      "The resulting Node value should be the same as what was added.");
    assertEquals(expectedResultCount, actualResultCount, "The resulting Collection should have a single Node.");
    assertEquals(expectedResultCount, actualResultEdgeCount, "The resulting Node should have a single Edge.");
  }

  @Test
  public void testAnEmptyGraphProperlyReturnsNull() {
    int expectedBucketsCount = 0;
    int expectedVerticesCount = 0;

    Graph sut = new Graph();

    ArrayList<Vertex> actualListOfNodes = sut.getNodes();
    assertNull(actualListOfNodes, "getNodes() should return null for initialized, empty Graph.");

    int actualBucketsCount = sut.getBucketsCount();
    assertEquals(expectedBucketsCount, actualBucketsCount,"Default buckets count should be 17.");

    int actualVerticesCount = sut.getVerticesCount();
    assertEquals(expectedVerticesCount, actualVerticesCount,
      "Actual vertices count should be zero as none have been added.");
  }
}
