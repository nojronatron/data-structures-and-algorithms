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
    // TODO: Consider changing return to Boolean so caller knows how to handle success vs failure condx
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
    // TODO: refactor this to use a private method FIND
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
    // TODO: refactor this to utilize a helper method to FIND
    LinkedListNode newNode = new LinkedListNode(newNodeValue);
    LinkedListNode currentNode = head;

    // create a previousNode reference so an insertion can be done before the Node with matching search value
    LinkedListNode previousNode = null;

    try {
      while (currentNode.value != null) {
        if (currentNode.value.equals(nodeValue)) {
          if (currentNode != head) {
            previousNode.next = newNode;
            newNode.next = currentNode;
          }
          else {
            newNode.next = head;
            head = newNode;
          }
          count++;
          return true;
        }
        previousNode = currentNode;
        currentNode = currentNode.next;
      }
    } catch (Exception ex) {
      System.out.println("An error occurred while searching or inserting to the Linked List. Message: " +
        ex.getMessage());
    }

    return false;
  }

  public boolean insertAfter(int nodeValue, int newNodeValue) {
    // TODO: refactor this to utilize a private helper method to FIND
    LinkedListNode newNode = new LinkedListNode(newNodeValue);
    LinkedListNode currentNode = head;

    try {
      while (currentNode.value != null) {
        if (currentNode.value.equals(nodeValue)) {
          newNode.next = currentNode.next;
          currentNode.next = newNode;
          count++;
          return true;
        }
        currentNode = currentNode.next;
      }
    } catch (Exception ex) {
      System.out.println("An error occurred while searching or inserting to the Linked List. Message: " +
        ex.getMessage());
    }

    return false;
  }

  public int getKthNodeFromEndValue(int idx) throws IndexOutOfBoundsException {
    // returns the value of the kth Node from the end of the linked list
    // Throws ArrayIndexOutOfBoundsException if idx < 0 or > number of Nodes in Linked List
    if (idx < 0 || idx > this.count) {
      throw new IndexOutOfBoundsException();
    }

    // if the 0th node from the end is selected it is the Tail node reference
    if (idx == 0) {
      return tail.value;
    }

    // if the 4th node from the end in a 5-node-list is wanted, that is the Head node reference
    if (idx == this.count - 1) {
      return head.value;
    }

    // set up temp and current Node instances
    LinkedListNode temp = null;
    LinkedListNode current = this.head;
    int counter = this.count; // count back from the end of the list of nodes by imaginary index

    // swap Nodes using temp and current until counter is equal to idx then exit iterator
    while(counter != idx) {
      temp = current;
      current = temp.next;
      counter--;
    }

    return current.value;
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
