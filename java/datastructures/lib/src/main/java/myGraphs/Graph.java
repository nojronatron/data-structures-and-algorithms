package myGraphs;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Graph {
  private int verticesCount = 0;
  protected HashMap<Integer, Vertex> adjacencyList;

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
  public Vertex addNode(Integer value) {
    Vertex newVertex = new Vertex(value);
    adjacencyList.put(newVertex.hashCode(), newVertex);
    this.verticesCount++;
    return newVertex;
  }

  /**
   * Using Breadth First Traversal, return a collection of nodes in the order they were visited.
   * @return
   */
  public ArrayList<Vertex> breadthFirst() {
    LinkedTransferQueue<Vertex> trackingQueue = new LinkedTransferQueue<>();
    // todo: consider using a HashSet<E> instead of ArrayList<T> to simplify unique checking in code
    // https://www.baeldung.com/java-hashset
    // https://www.baeldung.com/java-iterator
    ArrayList<Vertex> visitedList = new ArrayList<>();

    if (this.getBucketsCount() < 1) {
      return visitedList;
    }

    for(Vertex vertex: this.getNodes()) {
      if (vertex != null) {
        trackingQueue.add(vertex);
      }
    }

    while(!trackingQueue.isEmpty()) {
      Vertex currentVertex = trackingQueue.poll();
      Graph.addUnique(currentVertex, visitedList);

      ArrayList<Edge> attachedEdges = currentVertex.getEdges();

      for(Edge edge: attachedEdges) {
        // conditional added after whiteboarding
        if(edge.neighbor != null && !visitedList.contains(edge.neighbor)) {
         trackingQueue.add(edge.neighbor);
        }
      }
    }

    return visitedList;
  }

  /**
   * Helper method adds only unique items to the collection parameter visited.
   * Refactored to be static for testing purposes.
   * @param current
   * @param visited
   */
  public static void addUnique(Vertex current, ArrayList<Vertex> visited) {
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
   * Adds an Edge to the Graph based on reference of owning Vertex (node1) and neighbor Vertex (node2).
   * @param owner
   * @param neighbor
   */
  public void addEdge(Vertex owner, Vertex neighbor){
    Edge newEdge = new Edge();
    newEdge.setNeighbor(neighbor);
    int node1Hash = owner.hashCode();

    if (!owner.edges.contains(newEdge)) {
      owner.setEdge(newEdge);
    }

    adjacencyList.put(node1Hash, owner);
  }

  /**
   * Locates a Vertex within the Graph and returns a list of all Vertices with Edges.
   * @return collection
   */
  public ArrayList<Vertex> getNodes() {
    if (adjacencyList.isEmpty()) {
      return null;
    }

    Vertex startNode = null;
    var allKeys = adjacencyList.keySet();

    for(var item: allKeys) {
      startNode = adjacencyList.get(item);
      break;
    }

    ArrayList<Vertex> visited = new ArrayList<>();
    ArrayList<Vertex> result = breadthFirst(startNode, visited);

    return result;
  }

  /**
   * Breadth-first helper algorithm searches all Vertices in this Graph without duplication.
   * @param start
   * @param visited
   * @return collection
   */
  public ArrayList<Vertex> breadthFirst(Vertex start, ArrayList<Vertex> visited) {
    Queue<Vertex> breadth = new LinkedTransferQueue<>();
    ArrayList<Vertex> nodes = new ArrayList<>();

    breadth.add(start);
    visited.add(start);

    while(!breadth.isEmpty()) {
      Vertex front = breadth.poll(); // using poll() avoids a possible exception
      if (front != null) {
        nodes.add(front);

        for (Edge edge : front.getEdges()) {
          var child = edge.getNeighbor();
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
  public ArrayList<Edge> getNeighbors(Vertex node) {
    int nodeHash = node.hashCode();
    Vertex retrievedNode = adjacencyList.get(nodeHash);

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
