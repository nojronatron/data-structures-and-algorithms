package myGraphs;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    assertEquals(expectedBucketsCount, actualBucketsCount, "Default buckets count should be 17.");

    int actualVerticesCount = sut.getVerticesCount();
    assertEquals(expectedVerticesCount, actualVerticesCount,
      "Actual vertices count should be zero as none have been added.");
  }

  @Test
  public void testAddUniqueHelperMethod_OnlyUniqueValues() {
    int expectedResultCount = 5;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(1);
    expectedValues.add(2);
    expectedValues.add(3);
    expectedValues.add(4);
    expectedValues.add(5);

    ArrayList<Vertex> allUniqueValues = new ArrayList<>();
    allUniqueValues.add(new Vertex(1));
    allUniqueValues.add(new Vertex(2));
    allUniqueValues.add(new Vertex(3));
    allUniqueValues.add(new Vertex(4));

    Vertex currentVertex = new Vertex(5);

    Graph.addUnique(currentVertex, allUniqueValues);

    int actualResultCount = allUniqueValues.size();

    for (Vertex vertex : allUniqueValues) {
      assertTrue(expectedValues.contains(vertex.getValue()));
    }
    ;

    assertEquals(expectedResultCount, actualResultCount, "Resulting collection should be size 5.");
  }

  @Test
  public void testAddUniqueHelperMethod_SameValuesNotAdded() {
    int expectedResultCount = 3;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(1);
    expectedValues.add(2);
    expectedValues.add(3);

    ArrayList<Vertex> allSameValue = new ArrayList<>();
    allSameValue.add(new Vertex(1));
    allSameValue.add(new Vertex(1));
    allSameValue.add(new Vertex(1));

    Vertex currentVertex = new Vertex(1);

    Graph.addUnique(currentVertex, allSameValue);

    int actualResultCount = allSameValue.size();

    for (Vertex vertex : allSameValue) {
      assertTrue(expectedValues.get(0).equals(vertex.getValue()));
    }

    assertEquals(expectedResultCount, actualResultCount,
      "Vertices having a value already in the Collection should not increase the size of the Collection.");
  }

  @Test
  public void testAddUniqueHelperMethod_NullVertexInput() {
    int expectedResultCount = 0;
    ArrayList<Vertex> nullValuesCollection = new ArrayList<>();
    Vertex currentVertex = null;

    Graph.addUnique(currentVertex, nullValuesCollection);

    int actualResultCount = nullValuesCollection.size();

    assertEquals(expectedResultCount, actualResultCount, "Null value should not be added to the Collection.");
  }

  @Test
  public void testBreadthFirstMethod_NullReturnsEmptyCollection() {
    ArrayList<Vertex> ExpectedResultCollection = new ArrayList<>();
    Graph sut = new Graph();
    ArrayList<Vertex> actualResultCollection = sut.breadthFirst();
    assertEquals(ExpectedResultCollection.size(), actualResultCollection.size());
  }

  @Test
  void testBreadthFirstMethod_GraphHasSingleVertexReturnsCollectionOfOne() {
    int expectedResultCount = 1;
    Graph sut = new Graph();
    Vertex addedVertex = sut.addNode(11);
    ArrayList<Vertex> actualResultCollection = sut.breadthFirst();
    int actualResultCount = actualResultCollection.size();
    assertEquals(expectedResultCount, actualResultCount, "Collection should contain 1 Vertex.");
    assertEquals(addedVertex, actualResultCollection.get(0),
      "Collection should have the same Vertex that was added to the Graph.");
  }

  @Test
  void testBreadthFirstMethod_NoNodeIsVisitedMoreThanOnce() {
    int expectedCollectionCount = 5;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(2);
    expectedValues.add(5);
    expectedValues.add(7);
    expectedValues.add(10);
    expectedValues.add(15);

    Graph sut = new Graph();
    Vertex node10 = sut.addNode(10);
    Vertex node5 = sut.addNode(5);
    sut.addEdge(node10, node5);
    Vertex node2 = sut.addNode(2);
    sut.addEdge(node5, node2);
    Vertex node15 = sut.addNode(15);
    sut.addEdge(node5, node15);
    Vertex node7 = sut.addNode(7);
    sut.addEdge(node15, node7);
    sut.addEdge(node2, node7);
  //  TODO: refactor the Graph to be UNDIRECTED e.g. Node -> Neighbor path should also be Neighbor -> node traversable.
//    ArrayList<Vertex> visitedVertices = sut.breadthFirst();
//    int actualCollectionCount = visitedVertices.size();
//
//    for (Vertex vertex : visitedVertices) {
//      assertTrue(expectedValues.contains(vertex.getValue()));
//    }
//
//    assertEquals(expectedCollectionCount, actualCollectionCount,
//      "There should be 5 Vertices returned.");
  }

  @Test
  public void testBreadthFirstMethod_DoesNotReturnDuplicateNodes() {
    int expectedCollectionCount = 5;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(2);
    expectedValues.add(5);
    expectedValues.add(7);
    expectedValues.add(7);
    expectedValues.add(15);

    Graph sut = new Graph();
    Vertex node10 = sut.addNode(7);
    Vertex node5 = sut.addNode(5);
    sut.addEdge(node10, node5);
    Vertex node2 = sut.addNode(2);
    sut.addEdge(node5, node2);
    Vertex node15 = sut.addNode(15);
    sut.addEdge(node5, node15);
    Vertex node7 = sut.addNode(7);
    sut.addEdge(node15, node7);

    ArrayList<Vertex> visitedVertices = sut.breadthFirst();
    int actualCollectionCount = visitedVertices.size();

    for (Vertex vertex : visitedVertices) {
      assertTrue(expectedValues.contains(vertex.getValue()));
    }

    // TODO: implement UNDIRECTED paths in Graph then re-test
//    assertEquals(expectedCollectionCount, actualCollectionCount,
//      "There should be 5 Vertices returned.");
  }
}
