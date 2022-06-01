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

  // method enqueue takes a value and inserts value into pseudoQueue using FIFO
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

  // method dequeue takes no args and extracts a value from pseudoQueue using FIFO
  public T dequeue() {
    if (this.outputStack.count > 0) {
      T returnValue = this.outputStack.pop();
      this.count = this.inputStack.count + this.outputStack.count;
      return returnValue;
    }

    if (this.outputStack.count == 0 && this.inputStack.count > 0) {
      if(stackShift()) {
        T returnValue = this.outputStack.pop();
        this.count = this.inputStack.count + this.outputStack.count;
        return returnValue;
      }
    }
    // this.count == 0
    return null;
  }

  private boolean stackShift() {
    try
    {
      while(inputStack.count > 0) {
        this.outputStack.push(this.inputStack.pop());
      }
      return true;

    } catch (Exception ex) {
      System.out.println("An error occurred while stack shifting: " + ex.getMessage());
    }

    return false;
  }
}
