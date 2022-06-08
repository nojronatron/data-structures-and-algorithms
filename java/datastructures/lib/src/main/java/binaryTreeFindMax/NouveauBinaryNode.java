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

  public Boolean setLeft(NouveauBinaryNode<T> leftChild) {
    try {
      this.left = leftChild;
    } catch (Exception ex) {
      return false;
    }

    return true;
  }

  public NouveauBinaryNode<T> getRight() {
    return right;
  }

  public Boolean setRight(NouveauBinaryNode<T> rightChild) {
    try {
      this.right = rightChild;
    } catch (Exception ex) {
      return false;
    }

    return true;
  }
}
