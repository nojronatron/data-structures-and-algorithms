# Insertion Sort

## Summary

Starting with the supplied pseudocode, generate a whiteboard walking through the code given the supplied inputs, then
write code and full range of tests.

## Whiteboard Process
<!-- Embedded whiteboard image -->

![Whiteboard Process](./insertion-sort-whiteboard.jpg)

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

Time: O(n^2)

The algorithm must iterate through all elements in the array, and in cases where elementA is greater than elementB, an
inner iterator must cycle back through previous elements until elementA < elementB while shifting values within the
array. Best case scenario is O(n) for a sorted or very nearly sorted array. Worst-case is O(n^2) for a full descending-
sorted array.

Space: O(1)

No additional objects or collections are created, and the input array is edited in-place, so regardless of the size of
the input, the Space efficiency is O(1).

## Solution
<!-- Show how to run your code, and examples of it in action -->

1. Install IntelliJ IDE or another Java-capable IDE, and install Gradle.
2. Fork and then clone this code to your local workstation.
3. Execute `gradle build`
4. Open the Project and browse the [code](../../lib/src/main/java/sorting/algorithms).
5. Browse the [tests](../../lib/src/test/java/sorting/algorithms/TestInsertingSorter.java).

## Tests

Happy Path:

- Takes an array of unsorted integers and sorts them properly in ascending order.

Expected Failure

- There are no expected failures because only Integers can be processed by this function.

Edge Cases

- Should accept empty array and return an empty array.
- Zeroes and negative Integers should be accepted and properly processed.
- Single-value array should be accepted and returned.

## Status Report

- [X] Top-level README “Table of Contents” is updated
- [X] README for this challenge is complete
  - [X] Summary, Description, Approach & Efficiency, Solution
  - [X] Picture of whiteboard
  - [X] Link to code
- [ ] Feature tasks for this challenge are completed
- [ ] Unit tests written and passing
  - [ ] “Happy Path” - Expected outcome
  - [ ] Expected failure
  - [ ] Edge Case (if applicable/obvious)

