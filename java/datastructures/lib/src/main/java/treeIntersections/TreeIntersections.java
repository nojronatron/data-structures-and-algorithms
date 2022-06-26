package treeIntersections;

import binaryTreeFindMax.NouveauBinaryNode;

import java.util.ArrayList;
import java.util.List;

public class TreeIntersections<T> {

  /**
   * Accepts Root Binary Nodes of two Binary Trees and returns a list of duplicate values between them.
   * @param leftTree
   * @param rightTree
   * @return
   */
  public List<T> tree_intersection(NouveauBinaryNode<T> leftTree, NouveauBinaryNode<T> rightTree) {

    // 1. test if either tree is null or no nodes if so return empty array
    if (leftTree == null || rightTree == null) {
      return new ArrayList<T>();
    }

    // 2. initialize TraversedItems to store PreOrder Traversal output from "left tree"
    List<T> traversedItems = this.inOrder(leftTree);

    // 4. init variable 'capacity' to store len of traverse items collection
    int capacity = (int)Math.round(traversedItems.size() * 1.5); // will drop decimals

    // 5+ 6. init hashtable with LL chaining that is 1.5 x capacity
    Hashtable<Integer, Integer> hashtable = new Hashtable<>(capacity);

    // 7. iterate entire traversedItems collection
    for(T item:traversedItems) {
      // 8.     iterate: call hash function on currently selected item using modulo, prime, and traversedItems.count

      // 9.     iterate: capture step-8 returned hashIndex

      // 10.    iterate: call function to store item into hashtable w/ chaining

    }
    // 11. Init setCollection to store duplicate values
    List<T> setCollection = new ArrayList<>();

    // 12. re-init Traverseditems to store "right tree" values

    // 13. call PreOrderTraversal function on "right tree" and store results in TraversedItems collection

    // 14. iterate: entire traversedItems collection:

    // 15.    call: hash function

    // 16.    assign: returned value to hashIndex

    // 17.    test: currently selected item at hashIndex?

    // 18.    test true? => Add item to SetCollection

    // 19.    test false? => continue with next iteration

    // 20. return set-collection and exit the function
    return setCollection;
  }

  // 3. create recursive function preorder starting from parameter 'node', load the outputArray using inOrder traversal.
  protected List<T> inOrder(NouveauBinaryNode<T> rootNode) {
    List<T> result = new ArrayList<>();

    if (rootNode.getLeft() != null) {
      this.inOrder(rootNode.getLeft());
    }

    result.add(rootNode.getValue());

    if (rootNode.getRight() != null) {
      this.inOrder(rootNode.getRight());
    }

    return result;
  }

}
