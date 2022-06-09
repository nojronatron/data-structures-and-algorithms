package karyTree;

import java.util.ArrayList;

public class karyNode<T> {
  protected T value;
  protected ArrayList<karyNode<T>> children;

  public karyNode() {  }

  public karyNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public ArrayList<karyNode<T>> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<karyNode<T>> children) {
    this.children = children;
  }
}
