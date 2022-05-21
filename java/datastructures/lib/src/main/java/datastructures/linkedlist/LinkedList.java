package datastructures.linkedlist;

public class LinkedList
{
  // TODO: Implement try-catch structures to return semantically descriptive errors from within calling method
  protected LinkedListNode head;
  protected int count;

  public LinkedList() {
    head = new LinkedListNode(null);
  }

  public void insert(Integer value) {
    // TODO: test
    // adds a new node with the value to the head of the list with an O(1) time performance
    LinkedListNode Node = new LinkedListNode(value);

    if (count < 1) {
      head = Node;
    } else
    {
      Node.next = head; // connect new node to the current HEAD node
    }

    this.count++; // increment the count
  }

  public Boolean includes(Integer value) {
    // TODO: test
    // indicates whether that value exists as a Node's value somewhere within the list.
    LinkedListNode Node = head;

    while(Node != null) {
      // test for null which means we have reached the end of the list
      if (Node.value.equals(value)) {
        return true;
      }

      Node = Node.next; // use existing ref to point to the next node
    }

    return false;
  }
  @Override
  public String toString()
    {
      //  TODO: test
      // must iterate through existing Nodes and display their values as a single string

      LinkedListNode Node = head;
      StringBuilder stringBuilder = new StringBuilder();

      while(Node != null) {
        stringBuilder.append("[").append(Node.value).append("]");
        Node = Node.next;
        if (Node != null) {
          stringBuilder.append("=>");
        }
      }

      return stringBuilder.toString();
    }
}
