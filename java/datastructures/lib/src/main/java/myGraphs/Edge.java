package myGraphs;

public class Edge {
  private final Integer DEFAULT_WEIGHT = 5;
  protected Integer weight;
  protected Vertex neighbor;

  /**
   * Default CTOR, sets defaul weight of 5.
   */
  public Edge() {
    this.weight = DEFAULT_WEIGHT;
    this.neighbor = null;
  }

  /**
   * CTOR instantiates a new Edge with supplied weight and Vertex instance.
   * @param weight
   * @param neighbor
   */
  public Edge(Integer weight, Vertex neighbor) {
    this.weight = weight;
    this.neighbor = neighbor;
  }

  /**
   * Returns the Vertex instance attached to this the other side of this Edge AKA 'Neighbor'.
   * @return Vertex
   */
  public Vertex getNeighbor() {
    return neighbor;
  }

  /**
   * Sets the Vertex at end of this Edge to supplied Vertex instance.
   * @param neighbor
   */
  public void setNeighbor(Vertex neighbor) {
    this.neighbor = null;
    this.neighbor = neighbor;
  }

  /**
   * Returns the Integer weight valueu of this Edge instance. Default weight is 5.
   * @return weight
   */
  public Integer getWeight() {
    return weight;
  }

  /**
   * Sets the Weight of this Edge to supplied Integer.
   * @param weight
   */
  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    String neighborText = this.neighbor != null ? this.neighbor.getValue().toString() : "null";
    return "Edge to Vertex " + neighborText + " weight: " + this.weight + ".";
  }
}
