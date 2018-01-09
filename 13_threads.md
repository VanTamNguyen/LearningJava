# Threads


#### What exactly is a thread?

* An instance of Java class *java.lang.Thread* 
    * Like every other objects in Java, Thread objects have variables and method, live and die at heap memory
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
        
        // The overloaded method
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
To start a thread you have to call ```thread.start();```. This method call will start a new call stack. To summarize, following are the things happen when you call thread start:
* A new thread of execution starts (with a new call stack)
* Thread moves from *new* state to *runnable* state
* When the thread has chance to run (by the thread scheduler), its target run method will run and thread moves to *running* state.

#### Running Multiple Threads
***The behavior is not guaranteed***<br/>
* Nothing guarantees that threads will start running in order they were started.
* There is no guarantee that once a thread starts executing it will execute until it's done.
* A thread done being a thread when its target ```run()``` method completes.
* Once a thread has beed started, it can never be started again, ```IllegalThreadStateException``` will be thrown.


#### Thread Scheduler
Thread Scheduler is the part of the JVM (although most of JVMs map Java theads directly to OS threads) that decides which thread should be run and which thread should be taken out of running state. 


#### Thread States and Transitions
<p align="center"><img src="/images/thread_states.png" /></p>

A thread can only be in one of five states:
* ***New***, a thread is said in *new* state when an instance of java class Thread is created but not yet call ```start()``` method. In this point, it's a live ```Thread``` object but not yet a thread of execution. It's considered not alive.
* ***Runnable***, when the method ```start()``` is called, the thread will moves to ```runnable``` state. At this state, the thread will have chance to be picked up be Thread Scheduler to move to ```running``` state. But a thread can also return to ```runnable``` state after entering ```running``` state or comming back from ```blocked/waiting/sleeping``` state. 
* ***Running***, this is it, the big time when the code in the run method will be executed. The thread scheduler selects a thread from ```runnable``` pool to move it to state ```running```.
* ***Waiting/Blocked/Sleeping***, this is the state when a thread is not eligible to run. In other words, it's not runnable but it might return to runnable if a particular event occurs. A thread may be *blocked* waiting for a resource (such as IO or an object lock). A thread may be *sleeping* because the thread's run code tell it to sleep a period of time. A thread can be waiting because the thread's run code causes it to wait. The important point is that one thread does not tell the others to block. 
* ***Dead***, a thread is called *dead* when the run method completes. 

#### Interrupts




#### sleep()
The ```sleep()``` method is a static method of class ```java.lang.Thread```. It is used to force the current thread (important: current thread, no thread can tell others to sleep) to go to ```sleeping``` state. When a thread sleeps, it does not return runnable state until it wakes up. Notice that, the sleep method can throw checked InteruptedException.
```
try {
    Thread.sleep(60 * 1000); // Sleep 60 seconds
} catch (InteruptedException e) {
    // I am sleeping and is interrupted by someone so I have to wake up!
    // Meaning I can not complete the sleep for 60 seconds
} 
```
When an InteruptedException is thrown? When it's interupted before it's wake up time.

Remember ```sleep()``` method is a static method of class ```java.lang.Thread``` so don't be fool thinking that one thread can put another thread to sleep.


#### yield()

#### joind()


#### Threads Synchronization 
