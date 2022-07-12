package datastructures.linkedlist;

public class LinkedList {
  protected LinkedListNode head;
  protected LinkedListNode tail;
  protected int count;

  public LinkedList() {
    head = null;
    tail = head;
    count = 0;
  }

  public void insert(int value) {
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

  public Boolean includes(int value) {
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

      if (count > 1) {
        tail.next = newNode;
        tail = newNode;
        tail.next = null;
      }

      if (head != null && head == tail) {
        head.next = newNode;
        tail = newNode;
        tail.next = null;
      }

      if (head == null) {
        head = newNode;
        tail = head;
        tail.next = null;
      }

      count++;
      return true;
    }
    catch (Exception ex) {
      System.out.println("An error occurred while searching the Linked List. Message: " + ex.getMessage());
    }

    return false;
  }

  /**
   * Searched for a value in the Linked List and returns Node with targetValue if found, otherwise returns Null.
   * @param targetValue
   * @return LinkedListNode
   */
  public LinkedListNode find(int targetValue) {
    LinkedListNode top = head;

    while (top != null) {
      if (top.value == targetValue) {
        return top;
      }

      top = top.next;
    }

    return null;
  }

  /**
   * Given a value, find the LLNode with that value then return the Node PREVIOUS to it in the Linked List.
   * If not found or is Head.value equals targetValue then return Null.
   * @param targetValue
   * @return
   */
  public LinkedListNode findPrevious(int targetValue) {
    LinkedListNode current = head;

    if (head.value == targetValue) {
      return null;
    }

    current = head.next;
    LinkedListNode previous = head;

    while (current != null) {
      if (current.value == targetValue) {
        return previous;
      }

      previous = current;
      current = current.next;
    }

    return null;
  }

  public Boolean insertBefore(int beforeThisValue, int newNodeValue) {

    LinkedListNode previousNode = findPrevious(beforeThisValue);
    LinkedListNode nextNode = find(beforeThisValue);

    try {
      LinkedListNode newNode = new LinkedListNode(newNodeValue);
      newNode.next = nextNode;
      previousNode.next = newNode;
      this.count++;
      return true;
    } catch (Exception ex) {
      System.out.println("An error occurred while searching or inserting to the Linked List. Message: " +
        ex.getMessage());
    }

    return false;
  }

  public boolean insertAfter(int nodeValue, int newNodeValue) {

    try {
      LinkedListNode foundNode = find(nodeValue);
      LinkedListNode nextNode = foundNode.next;
      LinkedListNode newNode = new LinkedListNode(newNodeValue);

      newNode.next = nextNode;
      foundNode.next = newNode;
      this.count++;
      return true;
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

    // count back from the end of the list of nodes by imaginary index
    // remember that 0th from the end is Tail, and 0th from the start is Head
    int counter = this.count - 1;

    // swap Nodes using temp and current until counter is equal to idx then exit iterator
    while(counter != idx) {
      temp = current;
      current = temp.next;
      counter--;
    }

    return current.value;
  }

  /**
   * Removes and returns the Head Node from the Linked List and decrements the count.
   * Returns null if there are no Nodes in the Linked List.
   * @return LinkedListNode | Null
   */
  public LinkedListNode pop() {
    if (count < 1) {
      return null;
    }

    LinkedListNode temp = head;
    head = temp.next;
    temp.next = null;
    this.count--;
    return temp;
  }

  public static LinkedList zip(LinkedList left, LinkedList right) {
    if (left == null) {
      return right;
    }

    if (right == null) {
      return left;
    }

    LinkedList newLinkedList = new LinkedList();
    LinkedListNode newItem = null;

    try {

      while (true) {
        newItem = left.pop();
        if (newItem != null) {
          newLinkedList.append(newItem.value);
        } else {
          break;
        }

        newItem = right.pop();
        if (newItem != null) {
          newLinkedList.append(newItem.value);
        } else {
          break;
        }
      }

      while (left.count > 0) {
        newItem = left.pop();
        if (newItem != null) {
          newLinkedList.append(newItem.value);
        }
      }

      while (right.count > 0) {
        newItem = right.pop();
        if (newItem != null) {
          newLinkedList.append(newItem.value);
        }
      }

    } catch (Exception ex) {
      System.out.println("Something went wrong while zippering: " + ex.getMessage());
    }

    return newLinkedList;
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
