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
    int weight = 5;
    int expectedResultCount = 3;
    int expectedVerticesCount = 3;

    Graph<Integer> sut = new Graph<>();
    var node1 = sut.addNode(1);
    var node2 = sut.addNode(2);
    var node3 = sut.addNode(3);

    sut.addDirectionalEdge(node1, weight, node2);
    sut.addDirectionalEdge(node1, weight, node3);

    var actualBucketsInAdjacencyList = sut.getBucketsCount();
    var actualVerticesInThisGraph = sut.getVerticesCount();

    assertEquals(expectedVerticesCount, actualBucketsInAdjacencyList);
    assertEquals(expectedResultCount, actualVerticesInThisGraph);
  }

  @Test
  public void testGraphWithOnlyOneNodeAndEdgeCanBeReturned() {
    int weight = 5;
    int expectedResultCount = 1;
    Vertex<Integer> expectedNode = new Vertex<>(11);

    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> newNode = sut.addNode(11);
    sut.addDirectionalEdge(newNode, weight, null);

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

    Graph<Integer> sut = new Graph<>();

    ArrayList<Vertex<Integer>> actualListOfNodes = sut.getNodes();
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

    ArrayList<Vertex<Integer>> allUniqueValues = new ArrayList<>();
    allUniqueValues.add(new Vertex<>(1));
    allUniqueValues.add(new Vertex<>(2));
    allUniqueValues.add(new Vertex<>(3));
    allUniqueValues.add(new Vertex<>(4));

    Vertex<Integer> currentVertex = new Vertex<>(5);

    Graph<Integer> sut = new Graph<>();
    sut.addUnique(currentVertex, allUniqueValues);

    int actualResultCount = allUniqueValues.size();

    for (Vertex<Integer> vertex : allUniqueValues) {
      assertTrue(expectedValues.contains(vertex.getValue()));
    }

    assertEquals(expectedResultCount, actualResultCount, "Resulting collection should be size 5.");
  }

  @Test
  public void testAddUniqueHelperMethod_SameValuesNotAdded() {
    int expectedResultCount = 3;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(1);
    expectedValues.add(2);
    expectedValues.add(3);

    ArrayList<Vertex<Integer>> allSameValue = new ArrayList<>();
    allSameValue.add(new Vertex<>(1));
    allSameValue.add(new Vertex<>(1));
    allSameValue.add(new Vertex<>(1));

    Vertex<Integer> currentVertex = new Vertex<>(1);

    Graph<Integer> sut = new Graph<>();
    sut.addUnique(currentVertex, allSameValue);

    int actualResultCount = allSameValue.size();

    for (Vertex<Integer> vertex : allSameValue) {
      assertTrue(expectedValues.get(0).equals(vertex.getValue()));
    }

    assertEquals(expectedResultCount, actualResultCount,
      "Vertices having a value already in the Collection should not increase the size of the Collection.");
  }

  @Test
  public void testAddUniqueHelperMethod_NullVertexInput() {
    int expectedResultCount = 0;
    ArrayList<Vertex<Integer>> nullValuesCollection = new ArrayList<>();
    Vertex<Integer> currentVertex = null;

    Graph<Integer> sut = new Graph<>();
    sut.addUnique(currentVertex, nullValuesCollection);

    int actualResultCount = nullValuesCollection.size();

    assertEquals(expectedResultCount, actualResultCount, "Null value should not be added to the Collection.");
  }

  @Test
  public void testBreadthFirstMethod_NullReturnsEmptyCollection() {
    int expectedCollectionSize = 0;
    Graph<Integer> sut = new Graph<>();
    ArrayList<Vertex<Integer>> actualResultCollection = sut.breadthFirst();
    assertEquals(expectedCollectionSize, actualResultCollection.size());
  }

  @Test
  void testBreadthFirstMethod_GraphHasSingleVertexReturnsCollectionOfOne() {
    int expectedResultCount = 1;
    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> addedVertex = sut.addNode(11);
    ArrayList<Vertex<Integer>> actualResultCollection = sut.breadthFirst();
    int actualResultCount = actualResultCollection.size();
    assertEquals(expectedResultCount, actualResultCount, "Collection should contain 1 Vertex.");
    assertEquals(addedVertex, actualResultCollection.get(0),
      "Collection should have the same Vertex that was added to the Graph.");
  }

  @Test
  void testBreadthFirstMethod_NoNodeIsVisitedMoreThanOnce() {
    int weight = 5;
    int expectedCollectionCount = 5;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(2);
    expectedValues.add(5);
    expectedValues.add(7);
    expectedValues.add(10);
    expectedValues.add(15);

    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> node10 = sut.addNode(10);
    Vertex<Integer> node5 = sut.addNode(5);
    sut.addUndirectedEdge(node10, weight, node5);
    Vertex<Integer> node2 = sut.addNode(2);
    sut.addUndirectedEdge(node5, weight, node2);
    Vertex<Integer> node15 = sut.addNode(15);
    sut.addUndirectedEdge(node5, weight, node15);
    Vertex<Integer> node7 = sut.addNode(7);
    sut.addUndirectedEdge(node15, weight, node7);
    sut.addUndirectedEdge(node2, weight, node7);

    ArrayList<Vertex<Integer>> visitedVertices = sut.breadthFirst();
    int actualCollectionCount = visitedVertices.size();

    for (Vertex<Integer> vertex : visitedVertices) {
      assertTrue(expectedValues.contains(vertex.getValue()));
    }

    assertEquals(expectedCollectionCount, actualCollectionCount,
      "There should be 5 Vertices returned.");
  }

  @Test
  public void testBreadthFirstMethod_DoesNotReturnDuplicateNodes() {
    int weight = 5;
    int expectedCollectionCount = 4;
    ArrayList<Integer> expectedValues = new ArrayList<>();
    expectedValues.add(2);
    expectedValues.add(5);
    expectedValues.add(7);
    expectedValues.add(7);
    expectedValues.add(15);

    Graph<Integer> sut = new Graph<>();
    Vertex<Integer> node10 = sut.addNode(7);
    Vertex<Integer> node5 = sut.addNode(5);
    sut.addUndirectedEdge(node10, weight, node5);
    Vertex<Integer> node2 = sut.addNode(2);
    sut.addUndirectedEdge(node5, weight, node2);
    Vertex<Integer> node15 = sut.addNode(15);
    sut.addUndirectedEdge(node5, weight, node15);
    Vertex<Integer> node7 = sut.addNode(7);
    sut.addUndirectedEdge(node15, weight, node7);

    ArrayList<Vertex<Integer>> visitedVertices = sut.breadthFirst();
    int actualCollectionCount = visitedVertices.size();

    for (Vertex<Integer> vertex : visitedVertices) {
      assertTrue(expectedValues.contains(vertex.getValue()));
    }

    assertEquals(expectedCollectionCount, actualCollectionCount,
      "There should be 5 Vertices returned.");
  }

  @Test
  public void testGetSpecificItemInGraph() {
    int weight = 5;
    Graph<String> sut = new Graph<>();
    var alpha = sut.addNode("alpha");
    var bravo = sut.addNode("bravo");
    var charlie = sut.addNode("charlie");

    sut.addUndirectedEdge(alpha, weight, bravo);
    sut.addUndirectedEdge(alpha, weight, charlie);

    var foundVertex = sut.findVertex("alpha");
    assertEquals(alpha.value, foundVertex.value,
      "Searching for \"alpha\" should return a Vertex with value \"alpha\"");
  }

  @Test
  public void testBusinessTrip_TwoCitiesDirectlyConnectedReturnsCorrectValue() {
    String helena = "Helena";
    String buffalo = "Buffalo";

    ArrayList<String> twoCities = new ArrayList<>();
    twoCities.add(helena);
    twoCities.add(buffalo);

    Graph<String> sut = new Graph<>();
    var Helena = sut.addNode(helena);
    var Buffalo = sut.addNode(buffalo);

    sut.addUndirectedEdge(Helena, 150, Buffalo);

    var actualResult = sut.businessTrip(sut, twoCities);
    assertEquals("$150.00", actualResult,
      "The cost of the edge between Helena and Buffalo is 150 aka $150.00");
  }

  @Test
  public void testBusinessTrip_NullGraphInputResultsInNullReturn() {
    String helena = "Helena";
    String buffalo = "Buffalo";
    ArrayList<String> twoCities = new ArrayList<>();
    twoCities.add(helena);
    twoCities.add(buffalo);

    Graph<String> sut = new Graph<>();
    var actualResult = sut.businessTrip(sut, twoCities);

    assertNull(actualResult);
  }

  @Test
  public void testBusinessTrip_SingleCityCollectionResultsInCantCheckCitiesResponse() {
    String helena = "Helena";
    ArrayList<String> singleCityCollection = new ArrayList<>();
    singleCityCollection.add(helena);
    String buffalo = "Buffalo";

    Graph<String> sut = new Graph<>();
    var helenaVertex = sut.addNode(helena);
    var buffaloVertex = sut.addNode(buffalo);
    sut.addUndirectedEdge(helenaVertex, 150, buffaloVertex);
    var actualResult = sut.businessTrip(sut, singleCityCollection);

    assertNull(actualResult,
"Including just a single city in collection should return Null.");
  }

  @Test
  public void testBusinessTrip_ThreeCityCollectionResultsInCantCheckCitiesResponse() {
    var expectedResult = "$150.00";
    String seattle = "Seattle";
    String helena = "Helena";
    String buffalo = "Buffalo";
    ArrayList<String> threeCities = new ArrayList<>();
    threeCities.add(seattle);
    threeCities.add(helena);
    threeCities.add(buffalo);

    Graph<String> sut = new Graph<>();
    var seattleVertex = sut.addNode(seattle);
    var helenaVertex = sut.addNode(helena);
    var buffaloVertex = sut.addNode(buffalo);

    sut.addUndirectedEdge(seattleVertex, 300, buffaloVertex);
    sut.addUndirectedEdge(helenaVertex, 200, buffaloVertex);
    sut.addUndirectedEdge(seattleVertex, 150, helenaVertex);

    var actualResult = sut.businessTrip(sut, threeCities);

    assertEquals(expectedResult, actualResult,
      "Including a city list with more than 2 cities results only 1st two cities getting checked => $150.00");
  }

  @Test
  public void testBusinessTrip_exampleDataFromCodeChallengePassesMuster() {
    var expectedResult = "$82.00";
    var expectedResult2 = "$42.00";
    var expectedNoDirectFlights = "No direct flights found.";

    String pandora = "Pandora";
    String arendelle="Arendelle";
    String metroville="Metroville";
    String newMonstropolis="New Monstropolis";
    String narnia="Narnia";
    String naboo="Naboo";

    ArrayList<String> input1 = new ArrayList<>();
    input1.add(metroville);
    input1.add(pandora);

    ArrayList<String> input2 = new ArrayList<>();
    input2.add(arendelle);
    input2.add(newMonstropolis);
    input2.add(naboo);

    ArrayList<String> input3 = new ArrayList<>();
    input3.add(naboo);
    input3.add(pandora);

    ArrayList<String> input4 = new ArrayList<>();
    input4.add(narnia);
    input4.add(arendelle);
    input4.add(naboo);

    Graph<String> sut = new Graph<>();
    var vPandora = sut.addNode(pandora);
    var vArendelle = sut.addNode(arendelle);
    var vMetroville = sut.addNode(metroville);
    var vNewMonstropolis = sut.addNode(newMonstropolis);
    var vNarnia = sut.addNode(narnia);
    var vNaboo = sut.addNode(naboo);

    sut.addUndirectedEdge(vPandora, 150, vArendelle);
    sut.addUndirectedEdge(vPandora, 82, vMetroville);
    sut.addUndirectedEdge(vArendelle, 99, vMetroville);
    sut.addUndirectedEdge(vArendelle, 42, vNewMonstropolis);
    sut.addUndirectedEdge(vNewMonstropolis, 105, vMetroville);
    sut.addUndirectedEdge(vNewMonstropolis, 73, vNaboo);
    sut.addUndirectedEdge(vMetroville, 26, vNaboo);
    sut.addUndirectedEdge(vMetroville, 37, vNarnia);
    sut.addUndirectedEdge(vNarnia, 250, vNaboo);

    assertEquals(expectedResult, sut.businessTrip(sut,input1),
      "Inputs Metroville and Pandora should return $82.00");
    assertEquals(expectedResult2, sut.businessTrip(sut, input2),
      "Inputs Arendelle, New Monstropolis, and Naboo should return $155.00 (2 single-stop flights)");
    assertEquals(expectedNoDirectFlights, sut.businessTrip(sut, input3),
      "Inputs Naboo and Pandora should return \"No direct flights found.\".");
    assertEquals(expectedNoDirectFlights,sut.businessTrip(sut, input4),
      "Inputs Narnia, Arendelle, and Naboo should return \"No direct flights found.\".");
  }
}
