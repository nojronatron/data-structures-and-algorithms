package stack.and.queue;

public class PseudoQueue<T> {
  // implement the standard queue interface
  // utilize 2 Stack instances to create and manage this queue
  public int count;
  protected MyStack<T> outputStack;
  protected MyStack<T> inputStack;

  public PseudoQueue() {
    this.outputStack = new MyStack<>();
    this.inputStack = new MyStack<>();
    count = 0;
  }

  /**
   * Adds an item to the back of this queue following LILO (FIFO) ordering rules.
   * @param value of type T
   * @return boolean
   */
  public boolean enqueue(T value) {
    try {
      this.inputStack.push(value);
      this.count = inputStack.count + outputStack.count;
      return true;

    } catch (Exception ex) {
      System.out.println("An error occurred while Enqueuing: " + ex.getMessage());
    }

    return false;
  }

  /**
   * Returns the Front item of this queue following FIFO ordering rules.
   * @return T
   */
  public T dequeue() {
    if (this.outputStack.count > 0) {
      T returnValue = this.outputStack.pop();
      this.count = this.inputStack.count + this.outputStack.count;
      return returnValue;
    }

    if (this.outputStack.count == 0 && this.inputStack.count > 0) {
      if (stackShift()) {
        T returnValue = this.outputStack.pop();
        this.count = this.inputStack.count + this.outputStack.count;
        return returnValue;
      }
    }

    return null;
  }

  /**
   * Internal method moves items from input stack to output stack.
   * @return boolean
   */
  private boolean stackShift() {
    try {
      while (inputStack.count > 0) {
        this.outputStack.push(this.inputStack.pop());
      }
      return true;

    } catch (Exception ex) {
      System.out.println("An error occurred while stack shifting: " + ex.getMessage());
    }

    return false;
  }

  /**
   * Returns the value at the Front of the PseudoQueue, or Null if PseudoQueue is empty.
   * @return T
   */
  public T peek() {
    if (this.outputStack.count == 0 && this.inputStack.count > 0) {
      this.stackShift();
    }

    if (this.outputStack.count > 0) {
      return this.outputStack.peek();
    }

    return null;
  }
}
