# Threads


#### What exactly is a thread?

* An instance of Java class *java.lang.Thread* 
    * Like every other objects in Java, Thread objects have variables and method, live and die at heap memory.
* Thread of execution
    * A lightweight process that has its own call stack
    * Each thread a call stack or each call stack a thread
    
#### Making a thread
* Extend the class *java.lang.Thread* and override the method ```public void run()```
    * You can overload the run method but Thread class will ignore the overloaded method. Even if you call the overloaded run method directly, it will not start a new thread, it will execute the overloaded one in the thread that calls it.

* Implement *Runnable* interface

#### Threads Scheduler


#### Thread States and Transition



#### Threads Synchronization 
