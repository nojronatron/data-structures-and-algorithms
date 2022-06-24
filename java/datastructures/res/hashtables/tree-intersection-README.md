# Hashtable Tree Intersection

Write a function that will take two binary trees and return a collection representing a set of values found in *both trees*.

## Feature Tasks

- [ ] Write a function called tree_intersection that takes two binary trees as parameters.

- [ ] Using your Hashmap implementation as a part of your algorithm, return a set of values found in both trees.

## Structure and Testing

- [ ] Utilize the Single-responsibility principle.

- [ ] Methods you write should be clean, reusable, abstract component parts to the whole challenge.

- [ ] Write at least three test assertions for each method that you define.

- [ ] Ensure your tests are passing before you submit your solution.

## Stretch Goal

- [ ] Describe how you might solve this differently if the parameters were Binary Search Trees.

- [ ] What are the potential efficiency differences?

## Whiteboard Process
<!-- Embedded whiteboard image -->

![whiteboard image](hashtables-tree-intersection.jpg)

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

### Approach

The Hash Table will utilize Linked-Lists as the chaining method to manage duplicate hash indices.

I chose to work with each tree one at a time:

- "Left Tree" determines the size of the hash table by having its values loaded using a pre-order traversal to get the values right away.
- "Right Tree" values are later *compared* in a pre-order traversal (also, get values asap), and either dropped/ignored, or added to a storage array.

The output storage array represents the "middle of the venn diagram" of values between the two trees.

Functions are defined with very tightly scoped functionality and are expected to pass-on their results as rapidly as possible.

The tree-intersection function itself is mostly a directing method that drives execution of other methods and is ultimately responsible for returning the result.

### Efficiency

#### Time

There are multiple iterative functions within these custom functions, however only one nested pair, so the worst-case
scenario is of O(n^2) efficiency.

#### Space

A total of 5 storage items are created within this function, however only 2 of them are worse efficiency than O(1):
Creating the backing hashtable requires initializing an item into each index, and the total size is 1.5x the input,
which results in 3n storage requirements without storing any actual data. No storage/object creation of greater than
O(1) efficiency is performed, so overall storage efficiency is O(n).

## Solution
<!-- Show how to run your code, and examples of it in action -->

![Link to Code](../../lib/src/main/java/treeIntersections/TreeIntersections.java)

![Link to Tests](../../lib/src/main/java/datastructures/lib/src/test/java/treeIntersections/TreeIntersectionsTests.java)

## Submission Requirements

- [ ] Top-level README “Table of Contents” is updated

- [X] README for this challenge is complete

- [X] Summary, Description, Approach & Efficiency, Solution

- [X] Picture of whiteboard

- [X] Link to code

- [ ] Feature tasks for this challenge are completed

- [ ] Unit tests written and passing

- [ ] “Happy Path” - Expected outcome

- [ ] Expected failure

- [ ] Edge Case (if applicable/obvious)
