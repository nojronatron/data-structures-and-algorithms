package stack.and.queue;

public class MyQueue<T> {
  protected MyNode<T> front;
  protected MyNode<T> rear;

  public MyQueue() {
    this.front = null;
    this.rear = null;
  }

  public boolean enqueue(T value) {
    MyNode<T> newNode = new MyNode<>(value);

    if (this.isEmpty()) {
      // there are no nodes in the Queue so add new node and keep front and rear pointers on it
      this.rear = newNode;
      this.front = this.rear;
      return true;
    }

    if (this.front == this.rear && this.front != null) {
      // there is one node in the Queue so make front point to new Node then point new node next ref to rear
      this.rear = newNode;
      this.front.next = this.rear;
      return true;
    }

    if (this.front != this.rear) {
      // there are multiple nodes in the Queue so make rear next ref point to new node and set rear to new node
      this.rear.next = newNode;
      this.rear = newNode;
      return true;
    }

    return false;
  }

  public T dequeue() throws NullPointerException {
    // get a ref to front then test for single- or multiple occupancy then try to return the value to support NullPointerException
    MyNode<T> tempNode = this.front;

    if (this.front == this.rear && !this.isEmpty()) {
      // there is just one node in the queue so clean up the queue and return the front value
      this.front.next = null;
      this.rear = null;
      this.front = null;
    }

    if (this.front != this.rear && !this.isEmpty()) {
      // there are two or more nodes in the queue so move front pointer and return value stored in the old front
      this.front = this.front.next;
      tempNode.next = null;
    }

    return tempNode.value;
  }

  public T peek() throws NullPointerException {
    return front.value;
  }

  public boolean isEmpty() {
    return (this.front == this.rear && this.front == null);
  }

  @Override
  public String toString() {
    // traverse existing Nodes and display their values as a single string

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
