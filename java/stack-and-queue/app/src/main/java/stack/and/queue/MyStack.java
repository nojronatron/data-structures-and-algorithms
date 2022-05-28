package stack.and.queue;

public class MyStack<T> {
  protected MyNode<T> top;
  private int count;
  private boolean isEmpty;

  public T pop() {
    // returns the value of the top node, reducing stack size by 1

    if (this.top != null) {
      MyNode<T> temp = this.top;
      this.top = top.next;
      temp.next = null;
      this.count--;
      this.isEmpty = this.count > 0;
      return temp.value;
    }

    return null;
  }

  public boolean push(T value) {
    var newNode = new MyNode<T>(value);

    try {
      if (count > 0) {
        newNode.next = top;
      }
      top = newNode;
      this.isEmpty = this.count > 0;

      return true;

    } catch (Exception ex) {
      System.out.println("Something went wrong. " + ex.getMessage());
    }

    return false;
  }

  public T peek() {
    // return top.value only if top is not null
    return count > 0 ? this.top.value : null;
  }

  public boolean isEmpty() {
    // this is a getter method for this.isEmpty property
    return this.isEmpty;
  }
}
