# Hashtable Tree Intersection

Write a function that will take two binary trees and return a collection representing a set of values found in *both trees*.

## Feature Tasks

- [X] Write a function called tree_intersection that takes two binary trees as parameters.

- [X] Using your Hashmap implementation as a part of your algorithm, return a set of values found in both trees.

## Structure and Testing

- [X] Utilize the Single-responsibility principle.

- [X] Methods you write should be clean, reusable, abstract component parts to the whole challenge.

- [ ] Write at least three test assertions for each method that you define.

- [X] Ensure your tests are passing before you submit your solution.

## Stretch Goal

- [ ] Describe how you might solve this differently if the parameters were Binary Search Trees.

- [ ] What are the potential efficiency differences?

## Whiteboard Process
<!-- Embedded whiteboard image -->

![whiteboard image](hashtables-tree-intersection.jpg)

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

### Approach

The Hash Table will utilize Linked-Lists as the chaining method to manage duplicate hashed indices.

I chose to work with each tree one at a time:

- "Left Tree" values are loaded using a pre-order traversal to get the values into a tracking array.
- "Right Tree" values are later *compared* in a pre-order traversal and either dropped/ignored, or added to a result array.

Single-responsibility is achieved through:

- Recursive functions are retained in their own function code blocks.
- Globally-scoped variables are utilizes so multiple methods and code blocks can access them if/when needed.
- Built-in or custom methods on imported objects are used instead of re-writing or incorporating int a code block.

The output storage array represents the "middle of the venn diagram" of values between the two trees.

Copious in-line comments were added to help keep me from losing my place during testing, implementing, and refactoring.

### Leveraged Code

MyGenericHashtable: A custom-designed hashtable implementation with getHash(), add(), find(), and contains() methods following single-responsibility principle.

NouveauBinaryNode: A custom-designed Binary Node that has been well tested, follows single-responsibility, and is appropriate for this challenge.

TreeIntersections: The custom class where tree_intersection() method lives. Also contains a well-tested preOrder() recursive method.

### Efficiency

#### Time

There are multiple iterative functions within these custom functions, ~~however only one nested pair,~~ so the worst-case
scenario is ~~of O(n^2) efficiency~~ algorithmic complexity is O(n).

#### Space

A total of 5 storage items are created within this function, however only 2 of them are worse efficiency than O(1):
Creating the backing hashtable requires initializing an item into each index, and the total size is 1.5x the input,
which results in 3n storage requirements without storing any actual data. No storage/object creation of greater than
O(1) efficiency is performed, so overall storage efficiency is O(n).

## Solution
<!-- Show how to run your code, and examples of it in action -->

![Link to Code](../../lib/src/main/java/treeIntersections/TreeIntersections.java)

![Link to Tests](../../lib/src/test/java/treeIntersections/TreeIntersectionsTests.java)

## Submission Requirements

- [X] Top-level README “Table of Contents” is updated

- [X] README for this challenge is complete

- [X] Summary, Description, Approach & Efficiency, Solution

- [X] Picture of whiteboard

- [X] Link to code

- [X] Feature tasks for this challenge are completed

- [X] Unit tests written and passing

- [X] “Happy Path” - Expected outcome

- [X] Expected failure

- [X] Edge Case (if applicable/obvious)
