package datastructures.linkedlist;

public class LinkedList {
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

    try {

      if (count < 1) {
        head = Node; // HEAD and TAIL both point to same node
        tail = head;
        Node.next = null; // no other Nodes so next is null
      } else if (count == 1) {
        Node.next = head; // link new Node.next to current head node
        head = Node; // move HEAD pointer to new Node
        tail = head.next; // move TAIL pointer to old HEAD Node
      } else {
        Node.next = head; // add head to the new Node next
        head = Node; // assign HEAD pointer to the new Node
      }

      this.count++; // increment the count
    } catch (Exception ex) {
      // wouldn't normally catch a vanilla Exception and pass it on to the caller but YOLO
      System.out.println("Unable to insert Node in List. Exception: " + ex.getMessage());
    }

    // void method requires no return statement
  }

  public Boolean includes(Integer value) {
    // indicates whether that value exists as a Node's value somewhere within the list.
    LinkedListNode Node = head;

    try {

      while (Node != null && Node.value != null) {
        // test for null which means we have reached the end of the list
        if (Node.value.equals(value)) {
          return true;
        }

        Node = Node.next; // use existing ref to point to the next node
      }

    } catch (Exception ex) {
      System.out.println("An error occurred while searching the Linked List. Message: " + ex.getMessage());
    }

    return false;
  }

  public Boolean append(int value) {
    // create a new Node using value param and add to LL at end of list

    try {
      LinkedListNode newNode = new LinkedListNode(value);
      tail.next = newNode;
      tail = newNode;
      tail.next = null;
      count++;
      return true;
    }
    catch (Exception ex) {
      System.out.println("An error occurred while searching the Linked List. Message: " + ex.getMessage());
    }

    return false;
  }

  public Boolean insertBefore(int nodeValue, int newNodeValue) {
    // insert a new Node with value newNodeValue before node with nodeValue
    LinkedListNode newNode = new LinkedListNode(newNodeValue);
    LinkedListNode currentNode = head;

    // if head is the first instance of value then replace head with newNodeValue
    if (head.value == nodeValue) {
      newNode.next = head;
      head = newNode;
      return true;
    }

    // create a previousNode reference so an insertion can be done before the Node with matching search value
    LinkedListNode previousNode = head;
    currentNode = head.next;

    try {
      while (currentNode.value != null) {
        if (currentNode.value.equals(nodeValue)) {
          previousNode.next = newNode;
          newNode.next = currentNode;
          return true;
        }
        previousNode = previousNode.next;
        currentNode = currentNode.next;
      }
    } catch (Exception ex) {
      System.out.println("An error occurred while searching the Linked List. Message: " + ex.getMessage());
    }

    return false;
  }

  @Override
  public String toString() {
    // must iterate through existing Nodes and display their values as a single string

    LinkedListNode Node = head;
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
