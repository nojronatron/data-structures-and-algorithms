# Find Cost of Direct Flights In Graph

## Challenge

Determine if a direct flight is possible between two cities and return the cost of the direct flight.

## Features

- [X] Write a function called businessTrip.
- [X] Method takes a graph and an array of city names as input.
- [X] Method returns null if direct flight not available, or the cost of the flight if it is available.
- [X] Implement solution using "clean, reusable, abstract component parts".
- [X] Write at least 3 test cases (unittests) for each method created.
- [X] Ensure tests are passing.
- [X] Plan implementation by drawing a whiteboard to model and analyze the problem domain prior to implementation.

## Whiteboard

![Whiteboard of Business Trip Method Design](./business-trip-whiteboard.jpg)

## Structure and Testing

Utilize the Single-responsibility principle: any methods you write should be clean, reusable, abstract component parts to the whole challenge. You will be given feedback and marked down if you attempt to define a large, complex algorithm in one function definition.

Be sure to follow your language/frameworks standard naming conventions (e.g. C# uses PascalCasing for all method and class names).

Any exceptions or errors that come from your code should be contextual, descriptive, capture-able errors. For example, rather than a default error thrown by your language, your code should raise/throw a custom error that describes what went wrong in calling the methods you wrote for this lab.

Tests:

- [X] An empty graph returns null.
- [X] An empty array of cities returns null.
- [X] An array of one city returns ~~null (you don't really want to purchase a circular flight, do you?)~~ "Don't know which cities to check."
- [X] A graph with at least cities "Helena" and "Buffalo" included, and city list includes only "Helena" and "Buffalo", returns the cost "$150.00"

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

Utilized the existing methods in my graph class to find Vertices, and create a nondirected Graph.

Leveraged HashMap capability to find a Vertex by hashed index to get adjacency list or determine adjacent Vertices.

Utilize existing methods to get the Edges and the Cost of each Edge.

With those existing generalized Edge, Vertex, and Graph methods, the remaining logic was ensuring clean, expected inputs, and develop a sensible test for adjacency that would also quickly return a value if found.

### Big O: Time

This algorithm operational efficiency is O(n) in time.

Explanation:

The businessTrip() function implements a single looping structure which is an O(edges) efficiency, meaning the most
time will be taken by the Vertex that has edges to every-other Vertex in the Graph, which would boil-down to O(n).

The other possible inefficiency would be in the adjacency list. Although the HashMap uses an O(1) algorithm to index in
to the adjacency list to find the value/object. For a HashMap adjacency list that has lots of collisions, efficiency
will drop as the Bucket Sizes to something approaching O(n) for the max number in any Bucket (assuming linked lists).

### Big O: Space

This algorithm operational efficiency is O(1) in space.

Explanation:

No additional storage is created, and storage is not duplicated within the method. The input graph is utilized in-
place while executing the algorithm.

## API
<!-- Description of each method publicly available in your Graph -->

This Graph's businessTrip() method accepts a Graph of size N and an array of 2 cities possibly within the graph that may or may not be connected by a single edge.

To use this method:

1. Create an ArrayList of type String that has 2 city names in it.
2. Instantiate a new Graph class object.
3. Call graph instance method addNode and supply a city name as a value. Repeat for all cities in the Graph.
4. Remember to capture the returned Vertex from the previous step.
5. Call graph instance method addUndirectedEdge and supply the city-pair Vertices for each flight path between cities, along with the cost as input e.g. Helena, 150, Buffalo.
6. Call graph instance method businessTrip and include the Graph created above and Collection created above.
7. Store the result of the previous step in a String variable.
8. If the String is null, there was no direct flight between the cities, or cities were not found, or graph was empty.
10. If there is a direct flight between Helena and Buffalo, the resulting value will be "$150.00" (the value of the edge "weight").
