package myGraphs;

import java.util.ArrayList;

public class Vertex {
  protected Integer value;
  protected ArrayList<Edge> edges;

  /**
   * CTOR accepts a value (suggest: Integer) and instantiates this Vertex object.
   * @param value
   */
  public Vertex(Integer value) {
    this.value = value;
    this.edges = new ArrayList<>();
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public boolean setEdge(Edge edge) {
    return edges.add(edge);
  }

  public ArrayList<Edge> getEdges() {
    return edges;
  }

  public void setEdges(ArrayList<Edge> edges) {
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
