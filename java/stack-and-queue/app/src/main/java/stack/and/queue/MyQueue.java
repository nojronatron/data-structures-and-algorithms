package stack.and.queue;

public class MyQueue<T> {
  protected MyNode<T> front;
  protected MyNode<T> rear;
  private boolean isEmpty;

  public MyQueue() {
    this.front = null;
    this.rear = null;
    isEmpty = true;
  }

  public boolean enqueue(T value) {
    MyNode newNode = new MyNode(value);

    try {
      if (this.rear == null) {
        this.rear = newNode;
        this.front = this.rear;
      } else {
        rear.next = newNode;
        rear = newNode;
      }
      this.isEmpty();
      return true;
    } catch (Exception ex) {
      System.out.println("Something went wrong: " + ex.getMessage());
    }

    return false;
  }

  public T dequeue() {
    if (front != null) {
      MyNode<T> temp = front;
      front = front.next;
      temp.next = null;
      this.isEmpty();
      return temp.value;
    }

    return null;
  }

  public T peek() throws NullPointerException {
    return front.value;
  }

  public boolean isEmpty() {
    // getter-setter method for this.isEmpty property
    this.isEmpty = this.front == null;
    return this.isEmpty;
  }

  @Override
  public String toString() {
    // must iterate through existing Nodes and display their values as a single string

    MyNode<T> Node = front;
    StringBuilder stringBuilder = new StringBuilder();

    while (Node != null) {
      stringBuilder.append("[").append(Node.value).append("]");
      Node = Node.next;
      if (Node != null) {
        stringBuilder.append("->");
      }
    }

    stringBuilder.append("->NULL");
    return stringBuilder.toString();
  }

}
