package binarySearchTree;

import java.util.ArrayList;
import java.util.Locale;
import stack.and.queue.*;

public class BinarySearchTree extends BinaryTree {
  private boolean hasRootNode;
  protected MyQueue<BinaryNode> storageQueue;

  public BinarySearchTree() {
    super();
    storageQueue = new MyQueue<BinaryNode>() {};
    hasRootNode = this.root != null;
  }

  public BinarySearchTree(int rootNodeValue) {
    super(rootNodeValue);
    storageQueue = new MyQueue<BinaryNode>() {};
    hasRootNode = this.root != null;
  }

  // creates a new BinaryNode with received value and inserts it into the tree using Breadth Traversal to find first available edge
  public void add(int value) {
    BinaryNode newNode = new BinaryNode(value);
    BinaryNode tempNode = null;
    storageQueue.enqueue(this.root);

    while (!storageQueue.isEmpty()) {
      tempNode = storageQueue.dequeue();

      // heavily favor filling left child first
      if (tempNode.left == null) {
        tempNode.left = newNode;
        return;
      }

      // favor filling right child second
      if (tempNode.right == null) {
        tempNode.right = newNode;
        return;
      }

      // favor traversing to left child
      if (tempNode.left != null) {
        storageQueue.enqueue(tempNode.left);
      }

      // last resort traverse right child
      if (tempNode.right != null) {
        storageQueue.enqueue(tempNode.right);
      }
    }
  }

  // returns true if binary tree has values and the input value is found within the tree
  public boolean contains(int value) {
    try {
      if (this.root == null) {
        return false;
      }

      if (this.root.value == value) {
        return true;
      }

      this.outputArray = new ArrayList<>();
      if (this.orderWrapper(this.root, "post")) {
        return this.outputArray.contains(value);
      }
    } catch (ExceptionSorryDave esd) {
      return false;
    }

    return false;
  }

  // helper method calls the correct recursive function and returns the loaded array of values
  // yes this breaks YAGNI but it is here anyway
  private boolean orderWrapper(BinaryNode node, String order) throws ExceptionSorryDave {
    this.outputArray = new ArrayList<>();

    try {
      // code generation suggested this enhanced switch, replacing the much taller switch I had built
      switch (order.toLowerCase(Locale.ROOT)) {
        case "pre", "preorder" -> this.preOrder(node);
        case "in", "inorder" -> this.inOrder(node);
        default -> this.postOrder(node);
      }

    } catch (Exception ex) {
      throw new ExceptionSorryDave(ex.getMessage());
    }

    return true;
  }

  public boolean getHasRootNode() {
    return hasRootNode;
  }
}
