# Breadth Traverse a Graphs

## Challenge

Determine if a direct flight is possible between two cities and return the cost of the direct flight.

## Features

- [ ] Write a function called businessTrip.
- [ ] Method takes a graph and an array of city names as input.
- [ ] Method returns null if direct flight not available, or the cost of the flight if it is available.
- [ ] Implement solution using "clean, reusable, abstract component parts".
- [ ] Write at least 3 test cases (unittests) for each method created.
- [ ] Ensure tests are passing (Two unittests not pass until I implement UNDIRECTED edges (Graph is currently DIRECTED)).
- [ ] Plan implementation by drawing a whiteboard to model and analyze the problem domain prior to implementation.

## Whiteboard

![Whiteboard of Business Trip Method Design]()

## Structure and Testing

Utilize the Single-responsibility principle: any methods you write should be clean, reusable, abstract component parts to the whole challenge. You will be given feedback and marked down if you attempt to define a large, complex algorithm in one function definition.

Be sure to follow your language/frameworks standard naming conventions (e.g. C# uses PascalCasing for all method and class names).

Any exceptions or errors that come from your code should be contextual, descriptive, capture-able errors. For example, rather than a default error thrown by your language, your code should raise/throw a custom error that describes what went wrong in calling the methods you wrote for this lab.

Tests:

- [ ] An empty graph returns null.
- [ ] An empty array of cities returns null.
- [ ] An array of one city returns null (you don't really want to purchase a circular flight, do you?).

...

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->



Leveraged built-in Java classes TrackingQueue<E> and ArrayList<T> to ensure bug-free operation in those structures.

### Big O: Time


### Bit O: Space


## API
<!-- Description of each method publicly available in your Graph -->

This Graph's businessTrip() method accepts a Graph of size N and an array of 2 cities possibly within the graph that
may or may not be connected by a single edge.


To use this method:

1. Instantiate a new instance of the Graph class.
2. Call graph.addNode(value) for as many Vertices (or an existing Graph of Vertices) to add.
3. Note: Added Vertices MUST HAVE AN EDGE in order for traversal to function. Use my 'Vertex.java' class to be sure the Edge property is properly set.
4. Call graph.addEdge(vertex, neighbor) to "tie" two vertices together.
5. Call graph.breadthFirst() and store the return value as an ArrayList<Vertex> for inspection.
