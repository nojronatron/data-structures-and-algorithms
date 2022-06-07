package BinaryTreeFindMax;

import stack.and.queue.MyQueue;

import java.util.Queue;

public class NouveauBinaryTree<T> {
  private NouveauBinaryNode<Integer> root;
  private MyQueue<NouveauBinaryNode<Integer>> breadthQueue;

  public NouveauBinaryTree() {  }

  public NouveauBinaryTree(NouveauBinaryNode<Integer> root) {
    this.root = root;
  }

  public Integer findMax(){
    // use breadth traversal to find the largest integer
    if (root == null) {
      return null;
    }

    breadthQueue = new MyQueue<>();
    NouveauBinaryNode<Integer> tempNode = null;
    int maxValue = Integer.MIN_VALUE;
    breadthQueue.enqueue(root);

    while (breadthQueue.isEmpty() != true) {
      tempNode = breadthQueue.dequeue();
      maxValue = tempNode.getValue() > maxValue ? tempNode.getValue() : maxValue;

      if (tempNode.getLeft() != null) {
        breadthQueue.enqueue(tempNode.getLeft());
      }

      if (tempNode.getRight() != null) {
        breadthQueue.enqueue(tempNode.getRight());
      }
    }

    return return maxValue;
  }

}
