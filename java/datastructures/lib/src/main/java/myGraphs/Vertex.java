package myGraphs;

import java.util.ArrayList;

public class Vertex<T> {
  protected T value;
  protected ArrayList<Edge<T>> edges;

  public Vertex(T value) {
    this.value = value;
    this.edges = new ArrayList<>();
  }

  public int getHash() {
    return Math.abs(this.getValue().hashCode() * 599);
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

  @Override
  public int hashCode() {
    return Math.abs(String.valueOf(value).hashCode() * 599);
  }
}
