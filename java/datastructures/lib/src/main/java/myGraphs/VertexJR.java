package myGraphs;

import java.util.ArrayList;

public class VertexJR<T> {
  protected T value;
  protected ArrayList<VertexJR<T>> neighbors;

  public VertexJR(T value) {
    this.value = value;
    this.neighbors = new ArrayList<>();
  }

  /**
   * Add a new Vertex as a neighbor to this Vertex. There is no implemented sorting or arranging logic for the neighbors.
   * @param value
   * @return VertexJR
   */
  public VertexJR<T> addNode(T value) {
    VertexJR<T> newVertex = new VertexJR<T>(value);
    this.neighbors.add(newVertex);
    return newVertex;
  }

  

}
