package karyTree;

import org.apache.commons.math3.exception.OutOfRangeException;

import java.util.ArrayList;

public class KaryNode<T> {
  // the value this Node can hold
  protected T value;

  // the max expected children this Node will ever have
  protected int kMaxChildren;

  // the collection that holds child Nodes
  protected ArrayList<KaryNode<T>> children;

  public KaryNode() {
    kMaxChildren = 2;
    children = new ArrayList<>(2);
  }

  public KaryNode(T value) {
    this.value = value;
    this.kMaxChildren = 2;
    children = new ArrayList<>(2);
  }

  public KaryNode(T value, int maxChildren){
    this.value = value;
    this.kMaxChildren = Math.abs(maxChildren); // ensure unsigned integer is added to avoid throwing
    children = new ArrayList<>(maxChildren);
  }

  public T getValue() {
    return this.value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Boolean isEmpty(){
    return getValue() == null;
  }

  public Boolean hasChildren(){
    return this.children != null && this.children.size() > 0;
  }

  public Integer countChildren(){
    int count = 0;

    for(KaryNode<T> child: this.getChildren()) {
      if (child != null) {
        count++;
      }
    }

    return count;
  }

  public ArrayList<KaryNode<T>> getChildren() {
    if (this.children == null || this.children.size() < 1) {
      return null;
    }

    return this.children;
  }

  // sets a collection of children as the only set of child nodes to this Node
  public Boolean setChildren(ArrayList<KaryNode<T>> children) {
    try {
      if (children != null && children.size() <= this.kMaxChildren) {
        this.children = children;
      } else {
        System.out.println("Unable to add collection of child nodes. Max child nodes is " + this.kMaxChildren);
      }
    } catch (Exception ex) {
      System.out.println("Unable to add collection of child nodes to this node: " + ex.getMessage());
      return false;
    }

    return true;
  }

  // adds a single Node to this Nodes child array if its child array is not already full
  public Boolean addChild(KaryNode<T> childNode) {
    try {
      if (childNode != null && this.children.size() <= kMaxChildren) {
        return this.children.add(childNode);
      }
    } catch (OutOfRangeException oore) {
      System.out.println("Child node cannot be added here (k=" + kMaxChildren + ". " + oore.getMessage());
    }

    return false;
  }
}
