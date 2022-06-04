package BinarySearchTree;

public class BinaryNode {
  protected int value;
  protected BinaryNode left;
  protected BinaryNode right;

  public BinaryNode(){}

  public BinaryNode(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

}
