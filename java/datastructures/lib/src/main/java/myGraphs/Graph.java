package myGraphs;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Graph<T> {
  private final Integer DEFAULT_BUCKETS_COUNT = 17;
  protected HashMap<Integer, Vertex<T>> adjacencyList;

  /**
   * Default CTOR. Instantiates this Graph with a default buckets count.
   */
  public Graph() {
    adjacencyList = new HashMap<>(DEFAULT_BUCKETS_COUNT);
  }

  /**
   * Accepts a value (recommend Integer), creates a Vertex and adds it to this Graph.
   * @param value
   * @return vertex
   */
  public Vertex<T> addNode(T value) {
    Vertex<T> newVertex = new Vertex<>(value);
    adjacencyList.put(newVertex.getHash(), newVertex);
    return newVertex;
  }

  /**
   * Adds an Edge to the Graph based on reference of owning Vertex (node1) and neighbor Vertex (node2).
   * @param node1
   * @param node2
   */
  public void addEdge(Vertex<T> node1, Vertex<T> node2){
    Edge<T> newEdge = new Edge<>();
    newEdge.setNeighbor(node2);
    int node1Hash = node1.getHash();
    int indexHash = this.hashedIndex(node1Hash);

    if (!node1.edges.contains(newEdge)) {
      node1.setEdge(newEdge);
    }

    adjacencyList.put(indexHash, node1);
  }

  /**
   * Locates a Vertex within the Graph and returns a list of all Vertices with Edges.
   * @return collection
   */
  public List<Vertex<T>> getNodes() {
    if (adjacencyList.isEmpty()) {
      return null;
    }

    Vertex<T> startNode = null;
    var alKeys = adjacencyList.keySet();

    for(var item: alKeys) {
      startNode = adjacencyList.get(item);
      break;
    }

    ArrayList<Vertex<T>> visited = new ArrayList<>();
    ArrayList<Vertex<T>> result = breadthFirst(startNode, visited);

    return result;
  }

  /**
   * Breadth-first helper algorithm searches all Vertices in this Graph without duplication.
   * @param start
   * @param visited
   * @return collection
   */
  public ArrayList<Vertex<T>> breadthFirst(Vertex<T> start, ArrayList<Vertex<T>> visited) {
    Queue<Vertex<T>> breadth = new LinkedTransferQueue<>();
    ArrayList<Vertex<T>> nodes = new ArrayList<>();

    breadth.add(start);
    visited.add(start);

    while(!breadth.isEmpty()) {
      Vertex<T> front = breadth.poll(); // using poll() avoids a possible exception
      if (front != null) {
        nodes.add(front);

        for (Edge<T> edge : front.getEdges()) {
          var child = edge.getNeighbor();
          if (!visited.contains(child)) {
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
    int nodeHash = node.getHash();
    int indexHash = this.hashedIndex(nodeHash);
    Vertex<T> retrievedNode = adjacencyList.get(indexHash);

    if (retrievedNode == null) {
      return new ArrayList<>();
    }

    return new ArrayList<>(retrievedNode.getEdges()); // suggested by IntelliJ three-step program to one-liners
  }

  /**
   * Retuns index hash for this adjacency list at its current bucket count.
   * @param hash
   * @return hash
   */
  protected int hashedIndex(int hash) {
    return hash % getBucketsCount();
  }

  /**
   * Returns int count of Buckets in the adjacency list.
   * @return count
   */
  protected int getBucketsCount() {
    return adjacencyList.size();
  }
}
