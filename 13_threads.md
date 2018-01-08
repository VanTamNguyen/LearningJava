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


#### Threads Scheduler


#### Thread States and Transition



#### Threads Synchronization 
