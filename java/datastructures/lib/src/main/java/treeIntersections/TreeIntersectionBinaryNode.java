package treeIntersections;

public class TreeIntersectionBinaryNode<T> {
  protected T data;
  protected TreeIntersectionBinaryNode<T> left;
  protected TreeIntersectionBinaryNode<T> right;

  public TreeIntersectionBinaryNode(){
    this.data = null;
  }

  public TreeIntersectionBinaryNode(T value) {
    this.data = value;
  }

  public T getData() {
    return data;
  }

  public TreeIntersectionBinaryNode<T> getLeft() {
    return left;
  }

  public void setLeft(TreeIntersectionBinaryNode<T> left) {
    this.left = left;
  }

  public TreeIntersectionBinaryNode<T> getRight() {
    return right;
  }

  public void setRight(TreeIntersectionBinaryNode<T> right) {
    this.right = right;
  }

}
