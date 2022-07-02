package myGraphs;

import java.util.*;
import java.util.concurrent.LinkedTransferQueue;

public class Graph<T> {
  private final Integer DEFAULT_BUCKETS_COUNT = 17;
  protected HashMap<Integer, Vertex<T>> adjacencyList;

  public Graph() {
    adjacencyList = new HashMap<>(DEFAULT_BUCKETS_COUNT);
  }

  public Vertex<T> addNode(T value) {
    Vertex<T> newVertex = new Vertex<>(value);
    adjacencyList.put(newVertex.getHash(), newVertex);
    return newVertex;
  }

  public void addEdge(Vertex<T> node1, Vertex<T> node2){
    Edge<T> newEdge = new Edge<>();
    newEdge.setNeighbor(node2);
    Integer node1Hash = node1.getHash();

    if (!node1.edges.contains(newEdge)) {
      node1.setEdge(newEdge);
    }

    adjacencyList.put(node1Hash, node1);
  }

  public ArrayList<Vertex<T>> breadthFirst(Vertex<T> start) {
    ArrayList<Vertex<T>> nodes = new ArrayList<>();
    Queue<Vertex<T>> breadth = new LinkedTransferQueue<>();
    ArrayList<Vertex<T>> visited = new ArrayList<>();

    breadth.add(start);
    visited.add(start);

    while(!breadth.isEmpty()) {
      Vertex<T> front = breadth.remove();
      nodes.add(front);

      for(Vertex<T> child: front.getNeighbors()) {
        if (!visited.contains(child)) {
          visited.add(child);
          breadth.add(child);
        }
      }
    }

    return nodes;
  }
}
