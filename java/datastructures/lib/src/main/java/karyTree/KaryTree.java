package karyTree;

public class KaryTree<T> {
  protected KaryNode<T> root;

  public KaryTree() {
  }

  public KaryTree(KaryNode<T> rootNode) {
    this.root = rootNode;
  }

  public KaryNode<String> fizzBuzzConverter(KaryNode<Integer> inputNode) {
    if (inputNode == null || inputNode.getValue() == null) {
      return null;
    }

    KaryNode<String> resultRootNode = nodeRecursionTraversal(inputNode);
    return resultRootNode;
  }

  private KaryNode<String> nodeRecursionTraversal(KaryNode<Integer> inputNode) {
    // try postorder traversal, so that nodes can be converted and added from the bottom up
    KaryNode<String> resultNode = new KaryNode<>();

    // check for empty children if so get its fizzbuzz value and assign it to resultNode value
    if (!inputNode.hasChildren()) {
      resultNode.value = processFizzBuzz(inputNode.value);
    } else {
      // otherwise cycle through children and get their fizzbuzz string value, assign to resultNode value
      for(KaryNode<Integer> child: inputNode.getChildren()) {
        resultNode.addChild(nodeRecursionTraversal(child));
      }
      // store the fizzbuzz string value into result node
      resultNode.setValue(processFizzBuzz(inputNode.value));
    }

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
