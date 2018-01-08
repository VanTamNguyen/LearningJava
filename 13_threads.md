# Threads


#### What exactly is a thread?

* An instance of Java class *java.lang.Thread* 
    * Like every other objects in Java, Thread objects have variables and method, live and die at heap memory.
* Thread of execution
    * A lightweight process that has its own call stack
    * Each thread a call stack or each call stack a thread
    
#### Making a thread
* Extend the class *java.lang.Thread* and override the method ```public void run()```
    ```
    /**
    * Created by tamnv on 1/8/18.
    */
    public class SomeThread extends Thread {
        @Override
        public void run() {
            // New thead will execute code here
        }
        
        public void run(String string) {
        }
    }
    ```
    You can overload the run method but Thread class will ignore the overloaded method. Even if you call the overloaded run method directly, it will not start a new thread, it will execute the overloaded one in the thread that calls it.
    

* Implement *Runnable* interface
    ```
    /**
     * Created by tamnv on 1/8/18.
     */
    public class SomeTask implements Runnable {

        @Override
        public void run() {
            // Code for a new thread here
        }

        public static void main(String[] args) {
            SomeTask task = new SomeTask();
            Thread thread = new Thread(task);
            thread.start();
        }
    }
    ```
    Implement the *Runnable* interface will allow you to extend the class you like while accepting you define the behavior that will be run by a separate thread.
    

#### Starting Thread
To start a thread you have to call ```thread.start();```. This mothod call will start a new call stack. To summarize, following are the things happen when you call thread start:
* A new thread of execution starts (with a new call stack)
* Thread moves from *new* state to *runnable* state
* When the thread has chance to run (by the thread scheduler), its target run method will run and thread moves to *running* state.

#### Running Multiple Threads
***The behavior is not guaranteed:***<br/>
* Nothing guarantees that threads will start running in order they were started.
* There is no guarantee that once a thread starts executing it will execute until it's done.
* A thread done being a thread when its target ```run()``` method completes.
* Once a thread has beed started, it can never be started again, ```IllegalThreadStateException``` will be thrown.


#### Thread Scheduler
Thread Scheduler is the part of the JVM (although most of JVMs map Java theads directly to OS threads) that decides which thread should be run and which thread should be taken out of running state. 


#### Thread States and Transitions
A thread can only be in one of five states:
* ***New***
* ***Runnable***
* ***Running***
* ***Waiting/Blocked/Sleeping***
* ***Dead***



#### Threads Synchronization 
