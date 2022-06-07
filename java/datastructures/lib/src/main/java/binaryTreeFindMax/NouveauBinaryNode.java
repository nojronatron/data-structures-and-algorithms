package binaryTreeFindMax;

public class NouveauBinaryNode<T> {
  private T value;
  private NouveauBinaryNode<T> left;
  private NouveauBinaryNode<T> right;

  public NouveauBinaryNode() {  }

  public NouveauBinaryNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public NouveauBinaryNode<T> getLeft() {
    return left;
  }

  public void setLeft(NouveauBinaryNode<T> left) {
    this.left = left;
  }

  public NouveauBinaryNode<T> getRight() {
    return right;
  }

  public void setRight(NouveauBinaryNode<T> right) {
    this.right = right;
  }
}
