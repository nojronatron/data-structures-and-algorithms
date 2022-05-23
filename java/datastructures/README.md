# Data Structures

## Description

Develop data structures and algorithms using:

- OOP concepts
- References
- Gradle
- JUnit Jupiter
- And of course, Java

## List of Projects

[Linked Lists](#linked-lists)

(more to come)

## Linked Lists

### Challenge

Create a Linked List Node Class.
Create a Linked List Class.

### Requirements

Create a Node Class:

- Property for the value stored in the Node.
- Property pointing to the 'next' node.

Create a Linked List Class:

- Include a HEAD property.
- Include a custom (default) Constructor should create an empty Linked List when instantiated.
- Method: INSERT => args 'value', returns void, adds new Node with that value to the 'head' of the list with an O(1) Time performance.
- Method: INCLUDES => args 'value', returns Boolean, indicates whether the value exists as a Node's value somewhere within the list.
- Method: TOSTRING => Override, no args, returns String representing all the values in the Linked List.
- Method: APPEND => args 'new value', adds new node with given value to end of the Linked List.
- Method: INSERTBEFORE => args 'value, new value', adds new node with given value prior to first Node found with specified value.
- Method: INSERTAFTER => args 'value, new value', adds new Node with given value immediately following the first Node found with specified value.

#### ToString Override

An included requirement.

Returns `[a]->[b]->[c]->NULL` where a, b, and c are NODEs.

### LL Approach and Efficiency

My approach was to avoid loops whenever possible, however searching required an iterative approach.

Linked List Class:

Constructor => Time: O(1) Space: O(1) => Sets up Properties in single call
Insert => Time: O(1) Space: O(1) => Utilized HEAD reference and re-links Nodes without iterating
Includes => Time: O(n) Space: O(1) => No additional methods or object utilized
Append =>
InsertBefore =>
InsertAfter =>
ToString => Time: O(1) Space: O(1) => Avoids using immutable String type

### LL API

Description of each method publicly available to the Linked List:

- Constructor: Custom empty constructor sets Head, Tail to null.
- Insert: Accepts an Integer value and returns void.
- Includes: Accepts an Integer value and returns True if found in LL, otherwise False.
- ToString: See ToString Override (above). Returns all node values in Head-to-Tail order.

## Footer

Return to Data Structures and Algorithms root [Readme.md](../../README.md)
