package karyTree;

import java.util.ArrayList;

public class KaryTree<T> {
  protected T root;

  public KaryTree() {}

  public KaryTree(T rootNode) {
    this.root = rootNode;
  }

  public T getRoot() {
    return root;
  }

  public void setRoot(T root) {
    this.root = root;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public KaryNode<String> FizzBuzz(KaryTree<KaryNode<Integer>> karyTree) {
    if (karyTree.getRoot() == null || karyTree.getRoot().getValue() == null) {
      return null;
    }

    KaryNode<Integer> rootNodeParam = karyTree.getRoot();
    KaryNode<String> resultRootNode = null;

    resultRootNode = FizzBuzzRecursion(rootNodeParam);
    return resultRootNode;
  }

  private KaryNode<String> FizzBuzzRecursion(KaryNode<Integer> inputNode) {
    if (inputNode.getChildren() != null) // do better to avoid NullPointerException
      for(KaryNode<Integer> childNode: inputNode.getChildren()) {
        FizzBuzzRecursion(childNode);
    }

    //  process fizzybuzzy node values
    KaryNode<String> resultNode = new KaryNode<>();
    resultNode.setValue(processFizzBuzz(inputNode.getValue()));

    ArrayList<KaryNode<String>> kids = null; //inputNode.getChildren();
    boolean fizzBuzzResult = resultNode.setChildren(kids);

    return resultNode;
  }

  private String processFizzBuzz(Integer nodeValue) {

    if (nodeValue % 3 == 0 && nodeValue % 5 == 0) {
      return "FizzBuzz";
    }
    if (nodeValue % 3 == 0) {
      return "Fizz";
    }
    if (nodeValue % 5 == 0) {
      return "Buzz";
    }

    return nodeValue.toString();
  }
}
