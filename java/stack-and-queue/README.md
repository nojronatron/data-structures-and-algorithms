# Stacks and Queues

summary and background info

## Challenge

Implement both a stack and a Queue using lessons learned from creating and using Linked Lists.

## Approach and Efficiency

A design document was created prior to writing any code.

Big O analysis was used to keep space and time estimates linear or better in worst-case scenarios.

Whenever possible additional properties and Get/Setters were created to manage List Size and exception throwing situations in graceful ways.

Generics were implemented to allow the caller to use any Type or customer Class as their custom Node payload.

### Design

![Stacks and Queues Technical Design Drawing](./stack-and-queue.jpg)

### Big O Analysis

All Stack methods are O(1) operation because no iterations or recursive functions are used.

## API

Methods and their short descriptions

### Stack

Constructor: Only necessary to instantiate a Stack, and requires a value with a user-defined Type T.

Push: Accepts a value type T, creates a new Node of type T, adds it to top of the existing stack, sets the 'top' property to new Node T, and updates count and isEmpty properties.

Pop: Creates temporary Node and moves head pointer to previous Node, then returns temp Node value to the caller.

### Queue

Constructor:

Enqueue:

Dequeue:


## Tests

### STACK Tests

[X] Can successfully push onto a stack

[X] Can successfully push multiple values onto a stack

[X] Can successfully pop off the stack

[X] Can successfully empty a stack after multiple pops

[X] Can successfully peek the next item on the stack

[X] Can successfully instantiate an empty stack

[P] Calling pop or peek on empty stack raises exception

*Note*: Calling peek will return *null* instead of an Exception.

### QUEUE Tests

[ ] Can successfully enqueue into a queue

[ ] Can successfully enqueue multiple values into a queue

[ ] Can successfully dequeue out of a queue the expected value

[ ] Can successfully peek into a queue, seeing the expected value

[ ] Can successfully empty a queue after multiple dequeues

[ ] Can successfully instantiate an empty queue

[ ] Calling dequeue or peek on empty queue raises exception
