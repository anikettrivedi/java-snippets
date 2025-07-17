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

### JVM Pending questions
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