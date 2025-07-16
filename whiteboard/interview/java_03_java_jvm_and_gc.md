## Java JVM and Garbage Collection

### JVM

#### What is a Virtual Machine?
```
1 - A VM is a program that simulates behavior of a physical machine.
2 - Example:
    VMWare : System based VM
    JVM    : Application based VM
```

#### What is a JVM?
```
1 - Java Code (.java files) -> compiler -> Byte Code (.class files) -> JVM -> converts byte code to machine specific code.
2 - JVM makes Java platform independent.
3 - JVM is available for popular OS Kernels & CPU Architectures.
4 - JVM enables write once run anywhere.
```

#### Is JVM compiler or interpreter?
```
1 - JVM is an interpreter.
```

#### JRE vs JDK vs JVM
```
1 - JRE : Java Runtime Environment
    1 - JRE contains JVM, set of libraries & other files.
    
2 - JDK : Java Development Kit
    1 - JDK contains JRE, development & debugging tools.
    
3 - JVM, JDK & JRE are all platform dependent.
```

#### How JVM Works?
```
```

#### What is a Classloader?
```
1 - Set of components which loads classes into JVM during runtime.
2 - Not all classes loaded at once, when program needs that a particular class, Java Classloader loads it into memory. 
```

#### What activities are performed by Classloader Subsystem?
```
1 - Loading 

    1 - Reads class and generate binary code, which gets stored in method area. (An area in JVM Memory, Stack, Not Shared)
    2 - Creates an Object of type java.lang.Class, which gets stored in heap area. (Another area in JVM Memory, Shared)
    
2 - Linking

    1 - Verify
        1 - Verifies bytecode
        
    2 - Prepare
        1 - JVM allocates memory to class level variables and assigns default values to them.

    3 - Resolve
        1 - JVM replaces Symbolic Names with original memory references from the Method Area.

3 - Initialization

    1 - Original values get assigned to static variables.
    2 - Static blocks gets executed from parent to chile (top to bottom).
```

#### What are different class loaders used by JVM?
```
1 - Bootstrap or Premordial Classloader 
    
    1 - loads core java api classes i.e (jre/lib/rt.jar)
    2 - Parent of all other class loaders in Java.
    
2 - Extention Classloader

    1 - loads classes from (jre/lib/ext/*.jar)
    2 - Extention class loader is implementations of Bootstrap Classloader

3 - Application or System Classloader

    1 - loads classes from CLASSPATH env variable.
    2 - Child of ExtentionClassloader.
```

#### How does JVM load classes?
```
1 - Classloader works by delegating, one classloader delegates the responsibility of loading the class to their parent, if that doen't happen, then it them by itself.
```

#### Class.forName() vs ClassLoader.loadClass()
```

```

```
```

```
```

### JVM
1 - What is a JVM?

2 - Compile Time vs Run Time?

3 - How to configure JVM?

4 - Java Byte Code vs Machine Code?

5 - AOT vs JIT?

### Garbage Collectors
1 - What is a Garbage Collector?

2 - How Garbage Collector works?

3 - What are different kinds of Garbage Collectors available?

4 - How JVM works and its method of Garbage Collection?

5 - What happens when we call System.gc()