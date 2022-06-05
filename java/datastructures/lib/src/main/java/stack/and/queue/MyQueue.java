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
    try{
      if (this.front == this.rear && this.front == null) {
        // there are no nodes in the Queue so add new node and keep front and rear pointers on it
        this.rear = newNode;
        this.front = this.rear;
        return true;
      }

      if (this.front == this.rear && this.front != null) {
        // there is one node in the Queue so make front point to new Node then point new node next to rear
        // TODO: verify bug squashed
        this.rear = newNode;
        this.front.next = this.rear;
        return true;
      }

      if(this.front != this.rear && this.front != null && this.rear != null) {
        // there are more than one nodes in the Queue so make rear.next point to new node and set rear to new node
        this.rear.next = newNode;
        this.rear = newNode;
        return true;
      }
    } catch (Exception ex) {
      System.out.println("Something went wrong: " + ex.getMessage());
    }

    return false;
  }
/*
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
*/

  public T dequeue() {

    try {
      if (this.front == this.rear && this.front == null) {
        // there are no nodes in the queue so return null
        return null;
      }

      T tempValue = this.front.value;

      if (this.front == this.rear && this.front != null) {
        // there is just one node in the queue so clean up the queue and return the node
        this.front.next = null;
        this.rear = null;
        this.front = null;
        return tempValue;
      }

      if (this.front != null && this.rear != null && this.front != this.rear) {
        // there are two or more nodes in the queue so move front pointer and return value stored in front
        var tempNode = this.front;
        this.front = this.front.next;
        tempNode.next = null;
        return tempNode.value;
      }
    } catch (Exception ex) {
      System.out.println("Something went wrong: " + ex.getMessage());
    }
/*
    if (front != null) {
      MyNode<T> temp = front;
      front = front.next;
      temp.next = null;
      this.isEmpty();
      return temp.value;
    }
*/

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
