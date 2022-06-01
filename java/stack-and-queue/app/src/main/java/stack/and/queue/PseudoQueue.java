package stack.and.queue;

public class PseudoQueue<T> {
  // implement the standard queue interface
  // utilize 2 Stack instances to create and manage this queue

  protected MyStack<T> frontStack;
  protected MyStack<T> rearStack;

  public PseudoQueue(T value) {
    this.frontStack = new MyStack<>();
    this.rearStack = new MyStack<>();
  }

  // method enqueue takes a value and inserts value into pseudoQueue using FIFO
  public boolean enqueue(T value) {


    return false;
  }

  // method dequeue takes no args and extracts a value from pseudoQueue using FIFO
  public T dequeue() {


    return null;
  }
}
