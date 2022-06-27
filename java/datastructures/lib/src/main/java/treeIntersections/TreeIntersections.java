package treeIntersections;

import binaryTreeFindMax.NouveauBinaryNode;

import java.util.ArrayList;
import java.util.List;

public class TreeIntersections<T> {
  private List<T> traversedItems = new ArrayList<>();

  /**
   * Call this default constructor to make a TreeIntersections instance, then call tree_intersections method to do work.
   */
  public TreeIntersections() {  }

  /**
   * Accepts Root Binary Nodes of two Binary Trees and returns a list of duplicate values between them.
   * @param leftTree A NouveauBinaryNode, null or self or left and/or right child Nodes.
   * @param rightTree A NouveauBinaryNode, null or self or left and/or right child Nodes.
   * @return Collection of duplicated values at the intersection of the input trees.
   */
  public ArrayList<Integer> tree_intersection(NouveauBinaryNode<T> leftTree, NouveauBinaryNode<T> rightTree) {

    // 1. test if either tree is null or no nodes if so return empty array
    if (leftTree == null || rightTree == null) {
      return new ArrayList<Integer>();
    }

    // 2. initialize TraversedItems to store PreOrder Traversal output from "left tree"
    traversedItems = this.preOrder(leftTree); // O(n)

    // 4. init variable 'capacity' to store len of traverse items collection
    int capacity = (int)Math.round(traversedItems.size() * 1.5); // will drop decimals

    // 5+ 6. init hashtable with LL chaining that is 1.5 x capacity
    MyGenericHashtable hashtable = new MyGenericHashtable(capacity); // O(n) due to auto-init every bucket

    // 7. iterate entire traversedItems collection => an O(n) operation
    for(T traversedItem:traversedItems) {
      // 8.     iterate: call hash function on currently selected item using modulo, prime, and traversedItems.count
      // 9.     iterate: capture step-8 returned hashIndex
      // 10.    iterate: call function to store item into hashtable w/ chaining
      hashtable.add(traversedItem.toString(), (Integer)traversedItem);

    }
    // 11. Init setCollection to store duplicate values
    ArrayList<Integer> resultCollection = new ArrayList<>();

    // 12. re-init Traverseditems to store "right tree" values
//    traversedItems = null;
    traversedItems = new ArrayList<>();

    // 13. call PreOrderTraversal function on "right tree" and store results in TraversedItems collection
    traversedItems = this.preOrder(rightTree); // O(n)

    // 14. iterate: entire traversedItems collection => an O(n) operation
    for(T traversedItem: traversedItems) {
    // 15.    call: hash function
    // 16.    assign: returned value to hashIndex
    // 17.    test: currently selected item at hashIndex?
      //  both of these checks are O(n) because every item must be checked in worst-case scenario
      if(hashtable.contains(traversedItem.toString()) &&
          !resultCollection.contains((int)traversedItem)) {

        // 18.    test true? => Add item to SetCollection
        resultCollection.add((int) traversedItem); // O(n)
      }
    // 19.    test false? => continue with next iteration
    }

    // 20. return set-collection and exit the function
    return resultCollection;
  }

  // 3. create recursive function preorder starting from parameter 'node', load the outputArray using inOrder traversal.
  protected List<T> preOrder(NouveauBinaryNode<T> node) {
    // Preorder boils down to O(n): https://stackoverflow.com/questions/4547012/complexities-of-binary-tree-traversals
    traversedItems.add(node.getValue());

    if (node.getLeft() != null) {
      this.preOrder(node.getLeft());
    }

    if (node.getRight() != null) {
      this.preOrder(node.getRight());
    }

    return traversedItems;
  }

}
