package myGraphs;

import java.util.ArrayList;

public class Vertex<T> {
  protected T value;
  protected ArrayList<Edge<T>> edges;

  /**
   * CTOR accepts a value (suggest: Integer) and instantiates this Vertex object.
   * @param value
   */
  public Vertex(T value) {
    this.value = value;
    this.edges = new ArrayList<>();
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public void setEdge(Edge<T> edge) {
    edges.add(edge);
  }

  public ArrayList<Edge<T>> getEdges() {
    return edges;
  }

  public void setEdges(ArrayList<Edge<T>> edges) {
    this.edges = edges;
  }

  /**
   * Overrides Object.hashCode() and provides a custom hash calculation for this object.
   * @return
   */
  @Override
  public int hashCode() {
    return Math.abs(String.valueOf(value).hashCode() * 599);
  }
}
