package stack.and.queue;

import java.util.Objects;

public class BalancedBrackets {
  MyStack<String> storageStack;
  String[] inputCharacters;
  private int counter;

  public BalancedBrackets() {
    this.storageStack = new MyStack<>();
  }

  public boolean IsBalanced(String inputString) {
    this.inputCharacters = inputString.split("");
    int counter = 0;
    pairFinder();
    return storageStack.count == 0;
  }

  private void pairFinder() {
    while (counter < inputCharacters.length) {
      if (Objects.equals(inputCharacters[counter], storageStack.peek())) {
        storageStack.pop();
      } else {
        storageStack.push(inputCharacters[counter]);
      }
      counter++;
    }
  }
}
