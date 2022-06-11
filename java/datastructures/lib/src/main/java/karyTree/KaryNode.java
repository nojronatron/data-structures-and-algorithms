package karyTree;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class KaryNode<T> {
  // the value this Node can hold
  protected T value;

  // the max expected children this Node will ever have
  protected int kChildren;

  // the collection that holds child Nodes
  protected ArrayList<KaryNode<T>> children;

  public KaryNode() {
    kChildren = 2;
    children = new ArrayList<KaryNode<T>>(2);
  }

  public KaryNode(T value) {
    this.value = value;
    this.kChildren = 2;
    children = new ArrayList<KaryNode<T>>(2);
  }

  public KaryNode(T value, int maxChildren){
    this.value = value;
    this.kChildren = Math.abs(maxChildren); // ensure unsigned integer is added to avoid throwing
    children = new ArrayList<KaryNode<T>>(maxChildren);
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

  public ArrayList<KaryNode<T>> getChildren() {
    if (this.children == null || this.children.size() < 1) {
      return null;
    }

    return this.children;
  }

  // sets a collection of children as the only set of child nodes to this Node
  public Boolean setChildren(ArrayList<KaryNode<T>> children) {
    try {
      if (children != null && children.size() <= this.kChildren) {
        this.children = children;
      } else {
        System.out.println("Unable to add collection of child nodes. Max child nodes is " + this.kChildren);
      }
    } catch (Exception ex) {
      System.out.println("Unable to add collection of child nodes to this node: " + ex.getMessage());
      return false;
    }

    return true;
  }

  // adds a single Node to this Node if its child array is not already full
  public Boolean addNode(KaryNode<T> childNode) {
    try {
      if (childNode != null && this.children.size() <= kChildren) {
        return this.children.add(childNode);
      }
    } catch (OutOfRangeException oore) {
      System.out.println("Child node cannot be added here (k=" + kChildren + ". " + oore.getMessage());
    }

    return false;
  }
}
