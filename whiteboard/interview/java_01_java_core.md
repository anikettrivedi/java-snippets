## Java Core Interview Questions

<hr>

### Set vs List
1 - Two differences between Set & List?

#### Set
```
1 - Duplicates not allowed.
2 - May or may not preserve insertion order.
3 - Index based access not allowed.
```

#### List
```
1 - Duplicates allowed.
2 - Preserves insertion order.
3 - Index based access allowed.
```

### HashSet & HashMap
1 - How HashSet works?

```
1 - HashSet uses keys of HashMap internally.
2 - HashMap uses array of linkedlist to store objects.
3 - When a object is inserted into HashSet/HashMap, hashCode() method is used to detemine index in array
    index = hashCode() % array_size
4 - If array is empty at the location, object is simply inserted into it as a Node (LinkedList Node).
5 - In case of collision, LinkedList is parsed from head and each element is compared with the object to be inserted using equals()
6 - If equals returns true, it means a duplicate entry insert is attempted, in such case, no insertion happens and false is returned.
7 - If equals returns false for each node of linkedlist, object is simply added at the end of the linkedlist and true is returned.
```

2 - How Hashing happens?

```
1 - By default hashing happens using the hashCode() method on Object Class. This behavior can be overwritten by child classes to implement custom hashing.
2 - hashCode() returns an integer (representing location of the object in Java Heap)
3 - toString() also uses hexadecimal representation of hashCode() by default, though toString() is not used anywhere in hashing process.
```

3 - How HashMap handles collisions?

```
1 - By parsing the linked list and checking for duplicates.
2 - If not duplicate, element is added at the end of the linked list.
```

### ArrayList vs LinkedList

#### ArrayList
```
0 - Performance wise, ArrayList beats LinkedList in Read, Insertion & Deletion operations.
1 - Backed up by dynamic arrays, Java handles resizing internally.
2 - Uses arrays, so data stored in contiguous memory location.
3 - Index based access - O(1), Efficient, Random Access
4 - Sequencial access - Efficient, as contiguous memory location
5 - Inserts
    1 - add(e)        : O(1) amortized, Java will internally insure capacity, better performance than LinkedList
    2 - add(index, e) : O(n) as element need to be moved to right, better perfomance than LinkedList
6 - Deletion
    1 - remove(int index) : O(n) as element need to be moved to left. Better than linked list.
    2 - remove(Object object) : note it removes first occurence of the object
7 - Use cases
    1 - Fewer writes and frequent reads. Sequencial reads.
    2 - Index based reads.
    3 - When size of List is known beforehands.
    4 - When lower latency is important.
8 - Implementation details:
    1 - Implements List interface.
```

#### LinkedList
```
0 - Performance wise, ArrayList beats LinkedList in Read, Insertion & Deletion operations.
1 - Backed up by doubly linked list, resizing is not required.
2 - Data is not stored in contigous memory location.
3 - Index based access - O(n), Inefficient
4 - Sequencial access - Less efficient that ArrayList. Check performance.lists.ArrayListPerformance.
5 - Inserts
    1 - add(e)        : O(1) as element is simple added at the end of the list.
    2 - add(index, e) : O(n) as node at index needs to be searched first (more efficient)
6 - Deletion
    1 - remove (int index) : O(n) as index at node needs to be searched first 
7 - Use cases
    1 - Need queue or deque capabilities.
    2 - Fewer reads and frequent writes. Sequencial reads.
    3 - When size of List is not known before hands.
8 - Implementation details:
    1 - Implements List & Deque interfaces.
```

### Lambda Functions

1 - What is a Lambda Function and how it works?
```
1 - Lambda Function or Lambda Expression is a short block of code which takes in parameters and returns a valuse.
2 - They are similar to medhods, but they do not need a name and they can be implemented right in the body of a method.
```

2 - What are functional interfaces?
```
1 - A functional interface is an interface that contains only one abstract method. 
2 - Functional interfaces can have multiple default or static methods, but only one abstract method.
3 - Runnable, Callable are examples of functional interfaces.
4 - Lambda expressions and method references can be uses to represent and instance of functional interface.
```

