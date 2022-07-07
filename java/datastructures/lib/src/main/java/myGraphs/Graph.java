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
   * Adds an Edge to the Graph based on reference of owning Vertex (node1) and neighbor Vertex (node2).
   * @param node1
   * @param node2
   */
  public void addEdge(Vertex node1, Vertex node2){
    Edge newEdge = new Edge();
    newEdge.setNeighbor(node2);
    int node1Hash = node1.hashCode();

    if (!node1.edges.contains(newEdge)) {
      node1.setEdge(newEdge);
    }

    adjacencyList.put(node1Hash, node1);
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
    var alKeys = adjacencyList.keySet();

    for(var item: alKeys) {
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
