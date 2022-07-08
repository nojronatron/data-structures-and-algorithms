package myGraphs;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Graph<T> {
  private int verticesCount = 0;
  protected HashMap<Integer, Vertex<T>> adjacencyList;

  /**
   * Default CTOR. Instantiates this Graph with a default buckets count.
   */
  public Graph() {
    adjacencyList = new HashMap<>();
  }

  /**
   * Accepts a value (recommend Integer), creates a Vertex and adds it to this Graph.
   * @param value
   * @return vertex
   */
  public Vertex<T> addNode(T value) {
    Vertex<T> newVertex = new Vertex<T>(value);
    adjacencyList.put(newVertex.hashCode(), newVertex);
    this.verticesCount++;
    return newVertex;
  }

  /**
   * Using Breadth First Traversal, return a collection of nodes in the order they were visited.
   * @return
   */
  public ArrayList<Vertex<T>> breadthFirst() {
    LinkedTransferQueue<Vertex<T>> trackingQueue = new LinkedTransferQueue<>();
    // TODO: consider using a HashSet<E> instead of ArrayList<T> to simplify unique checking in code
    // https://www.baeldung.com/java-hashset
    // https://www.baeldung.com/java-iterator
    ArrayList<Vertex<T>>visitedList = new ArrayList<>();

    if (this.getBucketsCount() < 1) {
      return visitedList;
    }

    for(Vertex<T> vertex: this.getNodes()) {
      if (vertex != null) {
        trackingQueue.add(vertex);
      }
    }

    while(!trackingQueue.isEmpty()) {
      Vertex<T> currentVertex = trackingQueue.poll();
      this.addUnique(currentVertex, visitedList);

      ArrayList<Edge<T>> attachedEdges = currentVertex.getEdges();

      for(Edge<T> edge: attachedEdges) {
        // conditional added after whiteboarding
        if(edge.neighbor != null && !visitedList.contains(edge.neighbor)) {
         trackingQueue.add(edge.neighbor);
        }
      }
    }

    return visitedList;
  }

  /**
   * Method accepts an existing Graph and a Collection of 2 city names, searches the graph, for a direct flight
   * path between the two cities and returns the 'cost'. If direct flight is not found method returns 'No direct
   * flights found.'. Multi-stop flights are not calculated. Method will return
   * nulls for following conditions: Less than 2 vertices; city names count not equal to 2.
   * @param graph
   * @param twoCities
   * @return
   */
  public String businessTrip(Graph<T> graph, ArrayList<T> twoCities) {
    if (graph == null || graph.getBucketsCount() < 2) {
      return null;
    }

    if (twoCities.size() != 2) {
      return "Don't know which cities to check.";
    }

    T startCityValue = twoCities.get(0);
    var startCity = graph.findVertex(startCityValue);
    var numDirectFlights = startCity.getEdges().size();

    if (numDirectFlights < 1) {
      return null;
    }

    var destinationCity = twoCities.get(1);
    var dollarCost = "";

    for(Edge<T> edge: startCity.edges) {
      // if startCity's current edge neighbor value is destinationCity's name, get the Edge Cost, format as a string, and return it
      if (edge.getNeighbor().getValue().toString().toLowerCase(Locale.ROOT).equals(destinationCity.toString().toLowerCase(Locale.ROOT))) {
        dollarCost = String.format("$%1s.00", edge.getWeight());
        return dollarCost;
      }
    }

    return "No direct flights found.";
  }

  /**
   * Given a value, locate an existing Vertex within the Graph and return it.
   * @param value
   * @return
   */
  public Vertex<T> findVertex(T value) {
    Vertex<T> hashVertex = new Vertex<>(value);
    int indexToLookup = hashVertex.hashCode();
    Vertex<T> discoveredItem = this.adjacencyList.get(indexToLookup);
    return discoveredItem;
  }

  /**
   * Helper method adds only unique items to the collection parameter visited.
   * Refactored to be static for testing purposes.
   * @param current
   * @param visited
   */
  public void addUnique(Vertex<T> current, ArrayList<Vertex<T>>visited) {
    // handled a null-input bug post-whiteboarding
    if (current == null) {
      return;
    }

    if(visited.size() < 2) {
      visited.add(current);
      return;
    }

    boolean doesContain = false;

    for(int idx=0; idx <= visited.size() - 1; idx++){
      if (current.value.equals(visited.get(idx).value)) {
        return;
      }
    }

    if (!doesContain){
      visited.add(current);
    }
  }

  /**
   * Adds a DIRECTED Edge to the Graph based on reference of owning Vertex (node1) and neighbor Vertex (node2).
   * @param owner Vertex
   * @param neighbor Vertex
   */
  public void addDirectionalEdge(Vertex<T> owner, Integer weight, Vertex<T> neighbor){
    Edge<T> newEdge = new Edge<>();
    newEdge.setNeighbor(neighbor);
    newEdge.setWeight(weight);
    int node1Hash = owner.hashCode();

    if (!owner.edges.contains(newEdge)) {
      owner.setEdge(newEdge);
    }

    adjacencyList.put(node1Hash, owner);
  }

  /**
   * Adds an UNDIRECTED Edge to the graph based on references to two Vertices.
   * Literally ends up creating 2 Directed Edges.
   * @param neighbor_A Vertex
   * @param neighbor_B Vertex
   */
  public void addUndirectedEdge(Vertex<T> neighbor_A, Integer weight, Vertex<T> neighbor_B) {
    this.addDirectionalEdge(neighbor_A, weight, neighbor_B);
    this.addDirectionalEdge(neighbor_B, weight, neighbor_A);
  }

  /**
   * Locates a Vertex within the Graph and returns a list of all Vertices with Edges.
   * @return collection
   */
  public ArrayList<Vertex<T>>getNodes() {
    if (adjacencyList.isEmpty()) {
      return null;
    }

    Vertex<T> startNode = null;
    Set<Integer> allKeys = adjacencyList.keySet();

    for(Integer item: allKeys) {
      startNode = adjacencyList.get(item);
      break;
    }

    ArrayList<Vertex<T>>visited = new ArrayList<>();
    ArrayList<Vertex<T>>result = breadthFirst(startNode, visited);

    return result;
  }

  /**
   * Breadth-first helper algorithm searches all Vertices in this Graph without duplication.
   * @param start
   * @param visited
   * @return collection
   */
  public ArrayList<Vertex<T>>breadthFirst(Vertex<T> start, ArrayList<Vertex<T>>visited) {
    Queue<Vertex<T>>breadth = new LinkedTransferQueue<>();
    ArrayList<Vertex<T>>nodes = new ArrayList<>();

    breadth.add(start);
    visited.add(start);

    while(!breadth.isEmpty()) {
      Vertex<T> front = breadth.poll(); // using poll() avoids a possible exception
      if (front != null) {
        nodes.add(front);

        for (Edge<T> edge : front.getEdges()) {
          Vertex<T> child = edge.getNeighbor();
          if (!visited.contains(child) && child != null) {
            visited.add(child);
            breadth.add(child);
          }
        }
      }
    }

    return nodes;
  }

  /**
   * Returns list of Weight-to-Neighbor Vertices directly connected to this supplied Vertex argument.
   * @param node
   * @return Collection
   */
  public ArrayList<Edge<T>> getNeighbors(Vertex<T> node) {
    int nodeHash = node.hashCode();
    Vertex<T> retrievedNode = adjacencyList.get(nodeHash);

    if (retrievedNode == null) {
      return new ArrayList<>();
    }

    return new ArrayList<>(retrievedNode.getEdges()); // suggested by IntelliJ three-step program to one-liners
  }

  /**
   * Returns int count of Buckets in the adjacency list.
   * @return count
   */
  protected int getBucketsCount() {
    return adjacencyList.size();
  }

  /**
   * Returns count of Vertices added to this Graph.
   * @return count
   */
  public int getVerticesCount() {
    return this.verticesCount;
  }
}
