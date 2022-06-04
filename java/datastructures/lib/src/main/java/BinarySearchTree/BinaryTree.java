package BinarySearchTree;

import java.util.ArrayList;

public class BinaryTree {
  protected int count;
  protected ArrayList<Integer> outputArray = new ArrayList<>();

  protected BinaryNode root;

  public BinaryTree(){}

  public BinaryTree(int value) {
    root = new BinaryNode(value);
  }

  protected void inOrder(BinaryNode node) {
    if (node.left != null) {
      this.inOrder(node.left);
    }

    this.outputArray.add(node.value);

    if (node.right != null) {
      this.inOrder(node.right);
    }
  }

  protected void preOrder(BinaryNode node) {
    this.outputArray.add(node.value);

    if (node.left != null) {
      this.preOrder(node.left);
    }
    if (node.right != null) {
      this.preOrder(node.right);
    }
  }

  protected void postOrder(BinaryNode node) {
    if(node.left != null){
      this.postOrder(node.left);
    }
    if(node.right != null){
      this.postOrder(node.right);
    }

    outputArray.add(node.value);
  }
}
