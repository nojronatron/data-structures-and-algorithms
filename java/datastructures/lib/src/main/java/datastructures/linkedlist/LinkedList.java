package datastructures.linkedlist;

public class LinkedList
{
  // TODO: Implement try-catch structures to return semantically descriptive errors from within calling method
  protected LinkedListNode head;
  protected LinkedListNode tail;
  protected int count;

  public LinkedList() {
    head = new LinkedListNode(null);
    tail = head;
    count = 0;
  }

  public void insert(Integer value) {
    // adds a new node with the value to the head of the list with an O(1) time performance
    LinkedListNode Node = new LinkedListNode(value);

    if (count < 1) {
      head = Node; // HEAD and TAIL both point to same node
      tail = head;
      Node.next = null; // no other Nodes so next is null
    } else
      if (count == 1) {
      Node.next = head; // link new Node.next to current head node
      head = Node; // move HEAD pointer to new Node
      tail = head.next; // move TAIL pointer to old HEAD Node
    } else
    {
      Node.next = head; // add head to the new Node next
      head = Node; // assign HEAD pointer to the new Node
    }

    this.count++; // increment the count
  }

  public Boolean includes(Integer value) {
    // TODO: test
    // indicates whether that value exists as a Node's value somewhere within the list.
    LinkedListNode Node = head;

    while(Node != null && Node.value != null) {
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
