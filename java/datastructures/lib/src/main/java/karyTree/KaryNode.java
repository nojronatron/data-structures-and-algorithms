package karyTree;

import java.util.ArrayList;

public class KaryNode<T> {
  protected T value;
  protected ArrayList<KaryNode<T>> children; // consider setting this to null/initializing it in CTORs

  public KaryNode() {  }

  public KaryNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public ArrayList<KaryNode<T>> getChildren() {
    return children;
  }

  public Boolean setChildren(ArrayList<KaryNode<T>> children) {
    try {
      this.children = children;
    } catch (Exception ex) {
      System.out.println("Unable to add collection of child nodes to this node: " + ex.getMessage());
      return false;
    }

    return true;
  }
}
