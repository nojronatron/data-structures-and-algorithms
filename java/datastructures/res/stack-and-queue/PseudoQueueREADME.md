# Pseudo Queue

## How to Use

1. Install a Java JDK at version 17.x or higher
2. Install Gradle w/ JUnit Jupiter support
3. Clone this repo
4. CD to 'stack-and-queue' directory
5. To build: `./gradlew build` and review the output
6. To execute tests suite: `./gradlew test` and review the output

At this point you can import the packages 'MyStack' and 'MyQueue' by pointing to the main directory in this project

## Tools and Technologies

- Temurin Java JDK v17.x
- Gradle
- JUnit Jupiter test framework
- IntelliJ IDEA
- Linux
- Miro (for technical planning documentation)
- Java "Generics"

## Approach and Efficiency

The problem domain pointed out that 2 Stack Classes must be used to inplement Enqueue and Dequeue.

This could be seen literally as "use a Stack for Enqueue operations, another for Dequeue operations".

Using an Input Stack and Output Stack enables the following:

- All inputs are single-step operations, same as they are for a regular Stack Push() method call.
- All output are single-step operations assuming the Output Stack has values stored in it.

The challenge comes when the Output Stack is empty and Dequeue method is called.

If the Input Stack is also empty, which is a single-call test, then nothing need be done nor returned (perhaps an Exception?)

If the Input Stack has values (Nodes) then an iterating structure is necessary to POP from Input the PUSH to Output, one-by-one, until the Input Stack is empty.

Only after the Input Stack has been emptied can the Output Stack be asked to POP a Node in order to return the propertly "Dequeued" value.

## Design

![Pseudo Queue Design](./pseudo-queue-design.jpg)

## BigO Analysis

This was done in the Design drawing, but I will summarize here:

Enqueue(value): When input stack is empty or with nodes => O(1) operation as no iterators are necessary, and just a single New Node is created.

Dequeue(): When both Input and Output stacks are empty => O(1) as a test of the County properties is all that is necessary.

Dequeue(): When both Input and Output stacks HAVE NODES => O(1) because the Output Stack needs to be POPped just once and the Node value returned to the caller.

Dequeue(): When *only Input Stack* has Nodes => O(n) because multiple operations must be executed, including a single-level iterator to move all nodes from Input Stack to Output Stack *prior to* POPping the Output Stack and returning the Node value to the caller.

## API

boolean Enqueue(T value): Creates a New Node using the value param and a PUSH is performed into the Input Stack.

T Dequeue(): Returns a T value in multiple scenarios, however will return Null (or Exception) if there are no values in the PseudoQueue at all.

## Members

public Stack<T> InputStack: The 1st Stack used for ENQUEUE operations.

public Stack<T> OutputStack: The 2nd Stack leveraged when managing DEQUEUE operations.

public CTOR: Initialize InputStack and Output Stack.

public boolean Enqueue(T value): Adds a value at the Rear of the PseudoQueue.

public T Dequeue(): Returns value at Front of PseudoQueue.

public count: The total number of values (Nodes) being held in this PseudoQueue.

## Tests

-[X] Instantiating a new Queue does not throw.

-[X] Calling Dequeue() on an empty PseudoQueue returns Null.

-[X] Calling Enqueue() on an empty PseudoQueue increments the PseudoQueue count.

-[X] Calling Enqueue() multiple times, then calling Dequeue() once, then calling Enqueue() once correctly alters the PseuduQueue count.

-[X] Calling Enqueue() multiple times, then calling Dequeue() multiple times, then calling Enqueue() once correctly increments PseudoQueue count.

-[X] Calling Enqueue() multiple times to load [1, 2, 3, 4, 5], then calling Dequeue() multiple times returns [1, 2, 3, 4, 5].

## Link to code

Code for this challenge can be found in [this repo](../../datastructures/lib/src/main/java/stack/and/queue/PseudoQueue.java)
