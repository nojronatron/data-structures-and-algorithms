# Tree Fizz-Buzz Code Challenge

Write a function called fizz buzz tree that accepts a k-ary tree and returns a new k-ary tree with Fizz-Buzz updates.

## Requirements

- Write a function called fizz buzz tree
- Arguments: k-ary tree
- Return: new k-ary tree
- If the value is divisible by 3, replace the value with “Fizz”
- If the value is divisible by 5, replace the value with “Buzz”
- If the value is divisible by 3 and 5, replace the value with “FizzBuzz”
- If the value is not divisible by 3 or 5, simply turn the number into a String.

## Feature Tasks

- [X] Top-level README “Table of Contents” is updated
- [X] README for this challenge is complete
- [X] Summary, Description, Approach & Efficiency, Solution
- [X] Picture of whiteboard
- [X] Link to code
- [X] Feature tasks for this challenge are completed
- [X] Unit tests written and passing
- [X] “Happy Path” - Expected outcome
- [X] Expected failure
- [X] Edge Cases (if applicable/obvious)

## Whiteboard Process

![tree-fizz-buzz Whiteboard](tree-fizz-buzz.jpg)

## Approach & Efficiency

Approach:

- Use a recursive method that would eventually return the correct Node type as child to a temporary Node (or its children).
- If fizz or buzz or fizzbuzz detected for each node as it is traversed, return a String value and create a new Node from that.
- Do not use a stack or queue to store nodes in an iterative loop.
- Rely on custom functions attached to the Node Objects to test for children, add Child nodes, and create new Nodes (Constructors).


## Solution

I decided the only reason I needed a Tree class was to house the necessary methods, otherwise all other functionality
really needed to be kept within the k-Ary Node Class.

A Root Node of the proper output type is all that is needed to return from the required function.

Processing the input from an Integer type to a String type was a major headache, and the final solution was to use a
value-only helper method to change the Node.value Integer input to a String output (Fizz, Buzz, FizzBuzz, or a string
representation of the value), and then create a new String-type node, assign the string value to it, and then assign it
as a child to a temporary node so that the tree would "rebuild itself".



## Code

The implementation can be found in directory [java/datastructures/lib/src/main/java/karyTree](java/datastructures/lib/src/main/java/karyTree)

## Unit Tests

- [X] Happy Path
- [X] Edge Case(s)
- [X] Failure Case(s)

You can find the tests in this Java class file [java/datastructures/lib/src/test/java/karyTree/karyTreePackageTests.java](java/datastructures/lib/src/test/java/karyTree/karyTreePackageTests.java)

## Credits and Recognition

I would like to thank the following developers for their assistance in getting me to a working solution:

- Ben Mills
- Instructor Alex White
- Java magician Roger Reyes
