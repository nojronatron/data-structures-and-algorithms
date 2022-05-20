package datastructures.linkedlist;

public class LinkedList
{
  // TODO: Implement try-catch structures to return semantically descriptive errors from within calling method
  protected LinkedListNode head;
  protected int count;

  public LinkedList() {
    head = new LinkedListNode(null);
  }

  public void insert(Object value) {
    // TODO: test
    // adds a new node with the value to the head of the list with an O(1) time performance
    LinkedListNode Node = new LinkedListNode(1);

    if (count < 1) {
      head = Node;
    } else
    {
      Node.next = head; // connect new node to the current HEAD node
    }

    this.count++; // increment the count
  }

  public Boolean includes(Object value) {
    // TODO: implement
    // indicates whether that value exists as a Node's value somewhere within the list.

    return false;
  }
  @Override
  public String toString()
    {
      //  TODO: implement
      // must iterate through existing Nodes and display their values as a single string
      return "";
    }
}
