package BinarySearchTree;

public class MyNode<T> {
  protected T value;
  protected MyNode<T> next;

  public MyNode(T value) {
    this.value = value;
    this.next = null;
  }
}
