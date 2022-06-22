# Hash Tables Code Challenge

## Challenge

Implement a Hashtable Class with the following methods: SET, GET, CONTAINS, KEYS, and HASH.

## API

### set

Arguments: key, value

Returns: nothing

This method should hash the key, and set the key and value pair in the table, handling collisions as needed.
Should a given key already exist, replace its value from the value argument given to this method.

### get

Arguments: key

Returns: Value associated with that key in the table

### contains

Arguments: key

Returns: Boolean, indicating if the key exists in the table already.

### keys

Returns: Collection of keys

### hash

Arguments: key

Returns: Index in the collection for that key

## Approach & Efficiency

<!-- What approach did you take? Why? What is the Big O space/time for this approach? -->
### Approach

- Whenever possible avoid using loops and use direct access to reduce processing time.
- Componentize to avoid duplicating code or data whenever possible to be DRY and minimize storage space.
- Track the count of total entries, as well as the maximum size of backing array to avoid traversing the table.
- Utilize "Load Factor" as a means to determine if/whether collisions could happen.

### Big O Analysis

Time:

Looking up items at the underlying data layer is an O(1) operation.

Worst-case scenario for look-up is when the load factor is very high, Linked Lists are searched using an O(n) operation.

Inserting/Adding items is an O(n) operation because a search is done prior to storing to avoid duplicates.

Returning all the keys requires traversing the entire data structure including all Linked Lists so as the Load Factor
increases above 1, additional time is needed to gather all the keys, resulting in at best an O(n) operation.

Space:

Linked Lists are added to every bucket using an iterator at initialization time, effectively doubling the storage space,
which results in a O(n) storage utilization.

As data is added to the backing table the space does not change much because the buckets are pre-initialized, however,
as the Load Factor increases, the Linked Lists could insert data, but that is an O(1) operation, so it is negligible.

## Requirements

[X] Use single-responsibility principle

[X] Componentize all parts of the challenge

[X] Use standard naming conventions

[X] Handle errors and exceptions gracefully, using custom errors and messages

[X] Write tests (see TESTS subsection in this readme)

[X] Checklist the specifications and tasks in the opened, submitted PR for this assignment

[X] Track the amount of time it took to complete this assignment

[X] Note any difficulties encountered, or add comments as applicable

## Tests

Write tests to prove the following functionality:

[X] Setting a key/value to your hashtable results in the value being in the data structure

[X] Retrieving based on a key returns the value stored

[X] Successfully returns null for a key that does not exist in the hashtable

[X] Successfully returns a list of all unique keys that exist in the hashtable

[X] Successfully handle a collision within the hashtable

[X] Successfully retrieve a value from a bucket within the hashtable that has a collision

[X] Successfully hash a key to an in-range value

## Links

myHashTable [Class Definition](../../lib/src/main/java/myHashTable/MyHashtable.java)

myHashTable [Tests](../../lib/src/test/java/myHashTable/myHashTablePackageTests.java)

## Comments

The code challenge definition is pretty abstract and not well defined enough to actually implement a simple example.

In recent Java versions, Dictionary is deprecated so I decided to create a Record type instead so the Keys and Values
could be stored in a Linked List. Otherwise, the Linked List would not store the Key and would break lookups and the
Getter().

Why would a "Contains()" method return null instead of false? I implemented a Boolean Contains() method to work around
this design limitation.
