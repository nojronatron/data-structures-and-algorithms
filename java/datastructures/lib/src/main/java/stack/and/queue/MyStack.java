package stack.and.queue;

public class MyStack<T> {
  protected MyNode<T> top;
  protected int count;
  private boolean isEmpty;
  public MyStack() {
    this.top = null;
    this.count = 0;
    this.isEmpty = true;
  }

  public MyStack(T value) {
    this.top = new MyNode<T>(value);
    this.count = 1;
    this.isEmpty = false;
  }

  public T pop() {
    // returns the value of the top node, reducing stack size by 1

    if (this.top != null) {
      MyNode<T> temp = this.top;
      this.top = top.next;
      temp.next = null;
      this.count--;
      this.isEmpty();
      return temp.value;
    }

    return null;
  }

  public boolean push(T value) {
    // takes a generic value type, creates a new Node, and adds it to the top of the stack
    // adds to stack size by 1

    var newNode = new MyNode<T>(value);

    try {
      if (count > 0) {
        newNode.next = top;
      }
      top = newNode;
      this.count++;
      this.isEmpty();
      return true;

    } catch (Exception ex) {
      System.out.println("Something went wrong. " + ex.getMessage());
    }

    return false;
  }

  public T peek() throws NullPointerException {
    // return top.value only if top is not null
    //return count > 0 ? this.top.value : null;
    return this.top.value;
  }

  public boolean isEmpty() {
    // getter-setter method for this.isEmpty property
    this.isEmpty = (this.count == 0);
    return this.isEmpty;
  }

  @Override
  public String toString() {
    // must iterate through existing Nodes and display their values as a single string

    MyNode<T> Node = top;
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
