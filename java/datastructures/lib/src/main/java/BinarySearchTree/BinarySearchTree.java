package BinarySearchTree;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Queue;

public class BinarySearchTree extends BinaryTree {
  protected Queue<T> storageQueue;

  public BinarySearchTree(){
    super();
    storageQueue = new Queue<T>() {};
  }

  public BinarySearchTree(int rootNodeValue) {
    super(rootNodeValue);
    storageQueue = new Queue<T>() {};
  }

  public void add(int value) {

  }

  public boolean contains(int value) {

    return false;
  }

  private ArrayList<Integer> orderWrapper(BinaryNode node, String order) {
    this.outputArray = new ArrayList<>();
    
    switch (order.toLowerCase(Locale.ROOT)) {
      case "pre": case "preorder":
        this.preOrder(node);
        break;
      case "in": case "inorder":
        this.inOrder(node);
        break;
      default:
        this.postOrder(node);
        break;
    }

    return this.outputArray;
  }
}
