package datastructures.linkedlist;

public class LinkedList
{
  public LinkedListNode head;
  public LinkedList() {
    head = new LinkedListNode(null);
  }
  public void insert(LinkedListNode value) {
    // TODO: implement
    // adds a new node with the value to the head of the list with an O(1) time performance
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
