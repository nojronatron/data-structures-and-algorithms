package binaryTreeFindMax;

import stack.and.queue.MyQueue;
import java.util.ArrayList;

public class NouveauBinaryTree<T> {
  private NouveauBinaryNode<Integer> root;
  private MyQueue<NouveauBinaryNode<Integer>> breadthQueue;

  public NouveauBinaryTree() {  }

  public NouveauBinaryTree(NouveauBinaryNode<Integer> root) {
    this.root = root;
  }

  // method takes an arraylist<integer> of values and inserts them into this tree sorted by value top->bottom, left child to right child at each node
  public Boolean bulkLoadTree(ArrayList<Integer> bulkValues) {
    // TODO: TEST this method to bulk-load values into the tree using depth traversal preorder
    // method loads this tree with nodes based on integer values
    this.breadthQueue = new MyQueue<>();
    int idx = 0;

    if (this.isEmpty()) {
      this.root = new NouveauBinaryNode<Integer>(bulkValues.get(0));
      idx++;
    }

    this.breadthQueue.enqueue(root);
    NouveauBinaryNode<Integer> tempNode = null;

    try {
      while (!this.breadthQueue.isEmpty()) {
        tempNode = this.breadthQueue.dequeue();
        NouveauBinaryNode<Integer> newNode = null;

        if (tempNode.getLeft() == null &&
          idx < bulkValues.size()) {
          tempNode.setLeft(new NouveauBinaryNode<>(bulkValues.get(idx)));
          idx++;
          this.breadthQueue.enqueue(tempNode.getLeft());
        }

        if (tempNode.getRight() == null &&
          idx < bulkValues.size()) {
          tempNode.setRight(new NouveauBinaryNode<>(bulkValues.get(idx)));
          idx++;
          this.breadthQueue.enqueue(tempNode.getRight());
        }
      }

    } catch (Exception ex) {
      System.out.println("Exception thrown while breadth-inserting: " + ex.getMessage());
      return false;
    }

    return true;
  }

  public Integer findMax(){
    // use breadth traversal to find the largest integer
    if (root == null) {
      return null;
    }

    this.breadthQueue = new MyQueue<>();
    NouveauBinaryNode<Integer> tempNode = null;
    int maxValue = Integer.MIN_VALUE;
    this.breadthQueue.enqueue(root);

    while (!this.breadthQueue.isEmpty()) {
      tempNode = this.breadthQueue.dequeue();
      maxValue = tempNode.getValue() > maxValue ? tempNode.getValue() : maxValue;

      if (tempNode.getLeft() != null) {
        this.breadthQueue.enqueue(tempNode.getLeft());
      }

      if (tempNode.getRight() != null) {
        this.breadthQueue.enqueue(tempNode.getRight());
      }
    }

    return maxValue;
  }

  // method accepts a binary tree and returns an array of values in order they were encountered
  public ArrayList<Integer> getBreadthFirst(NouveauBinaryNode<Integer> rootNode) {
    if (rootNode == null || rootNode.getValue() == null) {
      return null;
    }

    this.breadthQueue = new MyQueue<>();
    var trackingArray = new ArrayList<Integer>();
    this.breadthQueue.enqueue(rootNode);

    try {
      while (!this.breadthQueue.isEmpty()) {
        var tempNode = this.breadthQueue.dequeue();
        trackingArray.add(tempNode.getValue());

        if (tempNode.getLeft() != null) {
          this.breadthQueue.enqueue(tempNode.getLeft());
        }

        if (tempNode.getRight() != null) {
          this.breadthQueue.enqueue(tempNode.getRight());
        }
      }
    } catch (Exception ex) {
      return null;
    }

    return trackingArray;
  }

  // returns true if root node is empty which (equivalent to an empty tree), false if occupied
  public Boolean isEmpty() {
    return root == null;
  }
}
