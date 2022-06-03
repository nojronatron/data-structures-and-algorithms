package stack.and.queue;

import java.util.Objects;

public class BalancedBrackets {
  private MyStack<String> storageStack;
  private String leftCompliments = "[{(";
  private String rightCompliments = "]})";
  private String[] inputCharacters;
  private int counter;

  public BalancedBrackets() {
    this.storageStack = new MyStack<>();
  }

  public boolean IsBalanced(String inputString) {
    if (inputString.length() < 1) {
      return false;
    }

    this.inputCharacters = inputString.split("");
    int counter = 0;
    pairFinder();
    return storageStack.count == 0;
  }

  private void pairFinder() {
    while (counter < inputCharacters.length) {
      String inputChar = inputCharacters[counter];

      if (storageStack.count < 1) {
        storageStack.push(inputChar);
        counter++;
        continue;
      }

      String nextNode = storageStack.peek();

      if (complimentary(inputChar, nextNode)) {
        storageStack.pop();
      } else {
        storageStack.push(inputChar);
      }

      counter++;
    }
  }

  private boolean complimentary(String left, String right){
    return (this.leftCompliments.contains(left) && this.rightCompliments.contains(right)) ||
            (this.leftCompliments.contains(right) && this.rightCompliments.contains(left));
  }
}
