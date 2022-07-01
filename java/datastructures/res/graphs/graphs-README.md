# Graphs

## Challenge

Graphs are similar to trees and linked lists in that there are nodes that store data and references to other nodes in a data structure.

## Features

- [ ] Graph should be represented as an adjacency list.
- [ ] Add node method. Arguments: value. Returns: The added node. Adds a node to the graph.
- [ ] Add edge method. Arguments: 2 nodes to be connected by the edge, weight (optional). Returns: nothing. Adds a new edge between two nodes in the graph. If specified, assign a weight to the edge. Both nodes should already be in the Graph.
- [ ] Get nodes method. Arguments: none. Returns all nodes in the graph as a collection (set, list, or similar).
- [ ] Get neighbors method. Arguments: node. Returns a collection of edges connected to the given node. Include the weight of the connection in the returned collection.
- [ ] Size method. Arguments: none. Returns the total number of nodes in the graph.
- [ ] Implement descriptive error handling.

## Structure and Testing

Utilize the Single-responsibility principle: any methods you write should be clean, reusable, abstract component parts to the whole challenge. You will be given feedback and marked down if you attempt to define a large, complex algorithm in one function definition.

Be sure to follow your language/frameworks standard naming conventions (e.g. C# uses PascalCasing for all method and class names).

Any exceptions or errors that come from your code should be contextual, descriptive, capture-able errors. For example, rather than a default error thrown by your language, your code should raise/throw a custom error that describes what went wrong in calling the methods you wrote for this lab.

Tests:

- [ ] Node can be successfully added to the graph
- [ ] An edge can be successfully added to the graph
- [ ] A collection of all nodes can be properly retrieved from the graph
- [ ] All appropriate neighbors can be retrieved from the graph
- [ ] Neighbors are returned with the weight between nodes included
- [ ] The proper size is returned, representing the number of nodes in the graph
- [ ] A graph with only one node and edge can be properly returned
- [ ] An empty graph properly returns null

## Approach & Efficiency
<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->

## API
<!-- Description of each method publicly available in your Graph -->
