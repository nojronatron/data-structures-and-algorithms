package stack.and.queue;

public class BalancedBrackets {
  private final MyStack<String> storageStack;
  private String leftCompliments = "[{(";
  private String rightCompliments = "]})";
  private String[] inputCharacters;
  private int counter;
  private boolean hasBrackets = false;

  public BalancedBrackets() {
    this.storageStack = new MyStack<>();
    this.counter = 0;
    this.inputCharacters = null;
  }

  /**
   * Takes a string input and returns true if it contains paired sets of any combination of backets [], braces {}, and parenthesis ().
   * @param inputString String
   * @return boolean
   */
  public boolean IsBalanced(String inputString) {
    try {
      if (this.isClean(inputString)) {
        this.hasBrackets = true;
        this.pairFinder();
      }
    } catch (NullPointerException nullPointerException) {
      return false;
    }

    return this.storageStack.count == 0 && this.hasBrackets;
  }

  /**
   * Private method strips away characters that are not bracket-like and sets internal isBracket Field to true if successful.
   * @param inputString String
   * @return boolean
   */
  private boolean isClean(String inputString) throws NullPointerException {
    if (inputString.length() > 0) {
      String cleansedInput = inputString.replaceAll("[\\d\\s\\w]", "");
      this.inputCharacters = cleansedInput.split("");
    }

    return this.inputCharacters.length > 0;
  }

  /**
   * Private method sifts stored input characters for bracket types then manages pairs using comparisons and a stack.
   */
  private void pairFinder() {
    while (this.counter < this.inputCharacters.length) {
      String inputChar = this.inputCharacters[counter];

      if (this.storageStack.count < 1) {
        this.storageStack.push(inputChar);
        this.counter++;
        continue;
      }

      String nextNode = this.storageStack.peek();

      if (complimentary(inputChar, nextNode)) {
        this.storageStack.pop();
      } else {
        this.storageStack.push(inputChar);
      }

      this.counter++;
    }
  }

  /**
   * Private method checks to see if the input and stored items are compliments.
   * @param left String
   * @param right String
   * @return boolean
   */
  private boolean complimentary(String left, String right){
    return (this.leftCompliments.contains(left) && this.rightCompliments.contains(right)) ||
            (this.leftCompliments.contains(right) && this.rightCompliments.contains(left));
  }
}
