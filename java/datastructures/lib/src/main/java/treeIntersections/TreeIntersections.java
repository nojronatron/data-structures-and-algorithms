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
  public List<Integer> tree_intersection(NouveauBinaryNode<T> leftTree, NouveauBinaryNode<T> rightTree) {

    // 1. test if either tree is null or no nodes if so return empty array
    if (leftTree == null || rightTree == null) {
      return new ArrayList<Integer>();
    }

    // 2. initialize TraversedItems to store PreOrder Traversal output from "left tree"
    List<T> traversedItems = this.preOrder(leftTree);

    // 4. init variable 'capacity' to store len of traverse items collection
    int capacity = (int)Math.round(traversedItems.size() * 1.5); // will drop decimals

    // 5+ 6. init hashtable with LL chaining that is 1.5 x capacity
    MyGenericHashtable hashtable = new MyGenericHashtable(capacity);

    // 7. iterate entire traversedItems collection
    for(T traversedItem:traversedItems) {
      // 8.     iterate: call hash function on currently selected item using modulo, prime, and traversedItems.count
      // 9.     iterate: capture step-8 returned hashIndex
      // 10.    iterate: call function to store item into hashtable w/ chaining
      hashtable.add(traversedItem.toString(), (Integer)traversedItem);

    }
    // 11. Init setCollection to store duplicate values
    List<Integer> resultCollection = new ArrayList<>(); // TODO: Rename this 'resultCollection'

    // 12. re-init Traverseditems to store "right tree" values
    traversedItems = null;

    // 13. call PreOrderTraversal function on "right tree" and store results in TraversedItems collection
    traversedItems = this.preOrder(rightTree);

    // 14. iterate: entire traversedItems collection:
    for(T traversedItem: traversedItems) {
    // 15.    call: hash function
    // 16.    assign: returned value to hashIndex
    // 17.    test: currently selected item at hashIndex?
      if(hashtable.contains(traversedItem.toString()) &&
          !resultCollection.contains((int)traversedItem)) {

        // 18.    test true? => Add item to SetCollection
        resultCollection.add((int) traversedItem);
      }
    // 19.    test false? => continue with next iteration
    }

    // 20. return set-collection and exit the function
    return resultCollection;
  }

  // 3. create recursive function preorder starting from parameter 'node', load the outputArray using inOrder traversal.
  protected List<T> preOrder(NouveauBinaryNode<T> rootNode) {
    List<T> result = new ArrayList<>();

    result.add(rootNode.getValue());

    if (rootNode.getLeft() != null) {
      this.preOrder(rootNode.getLeft());
    }

    if (rootNode.getRight() != null) {
      this.preOrder(rootNode.getRight());
    }

    return result;
  }

}
