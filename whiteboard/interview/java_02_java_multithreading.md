## Java Multithreading Interview Questions

<hr>

### Concurrency vs Parallelism

#### What is meant by Concurrency?

```
1 - A single process seemingly running multiple tasks at the same time.
2 - Creates an illusion of parallelism, but need not to be truly parallel.
3 - OS supports this by scheduling multiple threads on a single CPU core.
4 - Example: Multitasking in single core machine.
```

#### What is meant by Parallelism?

```
1 - When tasks are truly running at the same time.
2 - Example: 2 Tasks running in multi core processor. Each task in separate core.
```

<hr>

### Multithreading in Java

#### What is the use of Volatile Keyword?

```
1 - Volatile keyword is used in multithreaded environments to ensure visibility of changes to a variable accross different threads. 
2 - Volatile tells compiler that the value of variable must never be cached.
3 - Volatile keyword allows setting up happens before semantics to avoid data races. CPU executes update to volatile keyword in order of declaration and doesn't to reordering of instructions.
4 - Volatile keyword makes assignment to Long/Double atomic. (64 bit)
```

#### Volatile vs Synchronized

```
1 - Volatile
    1 - Makes assignment to Long/Double atomic.
    2 - Enables happens before semantics to avoid reording of instructions.
    3 - Less expensive than locking (Synchronized).
    4 - Use where locking might be overkill.
1 - Synchronized
    1 - Mutual Exclusion
    2 - Vibility
    3 - More expensive.
    4 - Use where atomicity is needed and volatile can't provide it.
```

#### What are Atomic Variables in Java? How are they different from traditional locking?

```
1 - Atomic Variables implements unsafe class.
2 - Utilize lower level CPU operations to ensure thread safety (Platform Specific)
3 - Implement lock free algorithms to insure atomicity of operations.
4 - An operation on Atomic variable is atomic, but two different operations may or may not be atomic.
```

#### What are Threads in Java?

```
1 - Thread in Java corresponds to platform thread (as provided by the OS).
2 - Each thread represents a separate task and can be run concurrently along with other threads.
3 - By default, a Java app runs in main thread. We can declare multiple threads to run concurrently along with main thread.
```

#### Virtual Thread vs Platform Thread vs CPU Core?

```
1 - Virtual Threads  : Introduced in Java 21, they are local to JVM, and are intended to make blocking IO operations more efficient by avoiding Thread scheduling/unscheduling cost incurred by platform threads.
2 - Platform Threads : Platform threads in Java have 1-1 mapping with OS Threads.
3 - CPU Core         : CPU core is a standalone CPU, multiple core processers what multiple CPUs.
```

#### Thread vs Runnable

```
1 - Runnable is just a functional interface, and on it's own, can't be run in parallel.
2 - Thread takes an object of runnable as constructor parameter, though runnable we can tell a thread what it needs to do.
3 - We can also extend Thread class and overwrite its run() method.
```

#### Runnable vs Callable

```
1 - Callable returns a value & runnable doesn't.
```

#### InterruptedException

```
1 - In order to handle thread interruptions, a method my explicitly catch InterruptedException and handle accordingly.
2 - If a thread is executing a method that doesn't handle InterruptedException, then thread.interrupt() doesn't do anything.
```

<hr>

### Concurrent Collections in Java

#### HashMap vs Concurrent HashMap vs Synchronized HashMap

```
1 - HashMap
    1 - Not thread safe.
    2 - One null key and multiple null values are allowed.
    3 - Fail fast iterator (ConcurrentModificationException)

2 - Concurrent HashMap
    1 - Thread safe.
    2 - Null keys and null values are not allowed.
    3 - Multiple threads can read & write to Concurrent HashMap simultaneously.
    4 - Fail safe iterator.
    
3 - Synchronized HashMap
    1 - Thread safe.
    2 - Only single thread can read or write to Synchronized HashMap. So it is not efficient.
    3 - A HashMap can be converted to Synchronzed HashMap using Collections.synchronizedMap() method.
    
```

#### How Concurrent HashMap works internally?
```
1 - Default level of concurrency is 16
2 - ConcurrentHashMap works similar to HashMap, with key differences
    1 - It is thread safe.
    2 - It is much more efficient than Synchronzied HashMap.
    3 - ConcurrentHashMap allows finer level of locking, as it locks the only a given segment of the map, so a thread accessing a given segment of map acquires lock only on that segment. Meaning other threads can continue reading/writing from other segments.
```

#### Is HashMap thread safe? How to make it thread safe?
```
1 - No, not thread safe.
2 - Use ConcurrentHashMap or call Collections.synchronizedMap() wrapper.
```

#### When to use HashMap vs Concurrent HashMap?
```
1 - HashMap
    1 - Single threaded access to read/write HashMap.
2 - Concurrent HashMap
    1 - Multiple threads reading from/writing to HashMap.
```

#### What is a Blocking Queue?
```
1 - Thread safe queue.
2 - Blocking
    1 - Producers are blocked if queue is full.
    2 - Consumers are blocked if queue is empty.
3 - Null elements not allowed.
4 - Implementations in Java
    1 - ArrayBlockingQueue
    2 - LinkedBlockingQueue
```

#### What is a CopyOnWriteArrayList & CopyOnWriteArraySet?
```
1 - Thread safe version of ArrayList
2 - Creates cloned copy of underlying ArrayList for every update(add,update) operation.
```

<hr>

### Locks in Java

1 - Fine Grained vs Coarse Grained Locking?

2 - Synchronized keyword?

3 - What is meant by a Reentrant Lock?

4 - Different kinds of Locks in Java?

### Deadlocks

1 - What is a deadlock?

2 - Conditions for a deadlock?

3 - How to avoid/handle deadlocks?

### Conditions on Locks in Java

1 - Object (wait(), notify(), notifyAll())

2 - Conditions (await(), signal(), signalAll())

### Semaphores in Java

1 - What are Semaphores?

2 - Difference between Semaphores and Locks?

### Connection Pooling

1 - Threads vs Executors?

2 - How executors are helpful?

3 - What kinds of Executors are available in Java?

4 - How to submit jobs to ThreadPool?

5 - How to stop tasks in a ThreadPool?

6 - Future vs CompletableFuture