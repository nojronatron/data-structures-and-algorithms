package karyTree;

import stack.and.queue.MyQueue;

public class KaryTree<T> {
  protected karyNode<T> root;
  protected MyQueue<karyNode<T>> karyQueue;
  private boolean isEmpty;

  public KaryTree() {}

  public KaryTree(karyNode<T> root) {
    this.root = root;
  }

  public karyNode<T> getRoot() {
    return root;
  }

  public void setRoot(karyNode<T> root) {
    this.root = root;
  }

  public boolean isEmpty() {
    return root == null;
  }

}
