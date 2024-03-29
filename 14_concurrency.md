# Concurrency

#### 1. Atomic Variables
* **[Test and set](https://en.wikipedia.org/wiki/Test-and-set)** is an *atomic instruction* provided by modern hardware systems to support synchronization.
    ```
    function TestAndSet(boolean_ref lock) {
        boolean initial = lock;
        lock = true;
        return initial;
    }
    ```
* **[Compare and swap](https://en.wikipedia.org/wiki/Compare-and-swap)** is another *atomic instruction* provided by modern hardware systems to support synchronization.
    ```
    function cas(p : pointer to int, old : int, new : int) returns bool {
        if *p ≠ old {
            return false
        }
        *p ← new
        return true
    }
    ```

* The ```java.util.concurrent.atomic``` package provides variables whose values can be modified atomically. All atomic operations of all classes in this package are based on ```Compare and swap```.

* Method ```getAndIncrement```'s implementation in ```AtomicInteger``` illustrates how atomic classes use CAS for thread safe.
    ```
    public int getAndIncrement() {
        for (;;) {
            int current = get();
            int next = current + 1;
            if (compareAndSwap(current, next)) {
                return current;
            }
        }
    }
    ```

* [Atomic coding example](code/src/com/tamco/concurrency/AtomicExample.java)

#### 2. Locks
* ```ReentrantLock``` implements ```java.concurrent.locks.Lock``` interface to provide standard **mutual exclusion**.
    * At most one thread at a time can hold ReentrantLock.

* ```ReentrantReadWriteLock``` implements ```java.concurrent.locks.ReadWriteLock```.
    ```
    public interface ReadWriteLock {
        Lock readLock();
        Lock writeLock();
    }
    ```
    * Mutual exclusion is a conservative locking strategy that prevents writer/writer, writer/reader overlap but also prevents reader/reader overlap.
    * Many data structures are **read-mostly**. In these cases, read-write lock comes to relax the locking requirements.
    * ***Read-write lock allows a resource can be accessed by multiple readers or a single writer at a time but not both.***
    * Use readLock for reading operations and writeLock for writing operations. Remember and keep it stuck in your mind: *readLock for reading and writeLock for writing*.


#### 3. Synchronized Collections
* **Synchronized collections** include ```Vector``` and ```Hashtable``` classes. And from Java 1.2, Java provides synchronized collection wrappers created by the ```Collections.synchronizedXxx()``` factory methods. These classes achieve thread safety by encapsulating their states and synchronizing every public methods so that one thread at a time can access collection state.
* For example, ```Collections.synchronizedList(List<E> list)``` returns a ```SynchronizedList``` wrapper object. ```SynchronizedList``` is a wrapper of ```List``` which synchronizes every public methods to achieve thread safety.

    ```
    static <T> List<T> synchronizedList(List<T> list) {
        return (list instanceof RandomAccess ?
                new SynchronizedRandomAccessList<>(list, mutex) :
                new SynchronizedList<>(list, mutex));
    }
    ```

#### 4. Concurrent Collections
* **Copy-On-Write Collections**
    * Derive (achieve) their thread safety from the fact that as long as an immuatble (read-only) object is properly published, no further synchronization is needed when accessing it.
    * They implement mutibility by creating and republishing a new copy of the colleciton every time it is modified.
    * Iterators for copy-on-write collections retain a reference to the backing collection that was current at the start of iteration. As the result, multiple thread can iterate the collection without interference from one another or from threads wanting to modify the collection.
    * The iterators returned by copy-on-write collections do not throw ```ConcurrentModificationException``` and return the elements exactly as they were at the time the iterator was created.

* **Concurrent Collections**
    * ```ConcurrentHashMap```
    * ```ConcurrentSkipListMap```
    * ```ConcurrentSkipListSet```
    * ```ConccurentLinkedDeque```
    * ```ConcurrentLinkedQueue```

* **Blocking Queue**<br/>
    Thread A (producing thread) put items to ```BlockingQueue```, thread B (consuming thread) get items from the queue. If the queue is full then thread A will be blocked while taking action of putting an item to the queue until thread B gets some items from the queue. And vice versa, if the queue is empty then thread B will be blocked while taking action of getting an item from the queue until thread A puts some items to the queue.<br/>

    The ```java.util.concurrent``` provides many implementations of ```BlockingQueue```:
    * ```ArrayBlockingQueue```
    * ```LinkedBlockingQueue```
    * ```LinkedBlockingDeque```
    * ```PriorityBlockingQueue```
    * ```DelayQueue```
    * ```LinkedTransferQueue```
    * ```SynchronousQueue```

#### 5. Executors and ThreadPool
To ultilize the CPU we need to control how many threads are created. So we need to decouple tasks from threads creation. ```java.util.concurrent.Executor``` comes to help. The basic usage will look something like this:

    Runnable task = new YourRunnable();
    Executor executor = // some implementations of Executor
    executor.execute(task);

* **Executor** is used to execute the run method in a runnable instance. By implementing to the ```Executor``` interface we can provide some threading approaches like these:
    * Not starting any thread at all (task is run in the calling thread)
        ```
        public class SingleThreadExecutor implements Executor {
            @Override
            public void execute(Runnable task) {
                task.run();
            }
        }
        ```
    * Starting new thread for each task
        ```
        public class SingleThreadExecutor implements Executor {
            @Override
            public void execute(Runnable task) {
                Thread thread = new Thread();
                thread.start(task);
            }
        }
        ```
    * Queue tasks and processing them with only enough threads (thread pool) to utilize CPU 

* **Executors** is factory for implementations of ```Executor```. It provides many standard implementations of Executor.

* **ExecutorService** is an interface that extends ```Executor```. Actually, ```Executors``` factory methods will return ```ExecutorService```. ExecutorService provides management capability and can return ```Future``` references that are used to obtain the result of executing the task asynchronously. 

    * *CachedThread Pools*<br/>
    ```ExecutorService ex = Executors.newCachedThreadPool()``` A cached thread pool will create threads as they needed to execute the tasks and reuse the threads that become free. Threads that have been idle for 60 seconds will be removed from the pool.

    * *FixedThread Pools*<br/>
    ```ExecutorService ex = Executors.newFixedThreadPool(10)``` A fixed thread pool will create a pool with a specific number of threads. This kind of thread pool will prevent an application from overloading a system with too many threads. Tasks that cannot be executed immediately are placed on an unbounded queue for later execution.

    * *SingleThread Pools*<br/>
    ```ExecutorService ex = Executors.newSingleThreadExecutor()``` A single thread executor uses only one thread to execute tasks. The tasks that cannot be executed immediately are placed on an unbounded queue for later execution.

* **ScheduledThread Pool** is used to execute tasks after a delay or at repeating interval.
    ```
    ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
    
    // Run a task with a delay of 5 seconds
    ses.schedule(task, 5, TimeUnit.SECONDS);
    
    // Run a task repeatedly with an interval of 5 seconds after a delay of 2 seconds
    ses.scheduleAtFixedRate(task, 2, 5, TimeUnit.SECONDS); 
    
    // Run a task repeatedly after the previous task completes 5 seconds, the first task runs after a delay of 2 seconds.
    ses.scheduleWithFixedDelay(task, 2, 5, TimeUnit.SECONDS); 
    ```

* **Callable Interface**<br/>
The ```java.util.concurrent.Callable``` interface serves the same purpose as the ```Runnable``` interface, but provides more flexibility. An ```ExecutorService``` can be passed a ```Callable``` instead of a ```Runnable```. A Callable may return a result upon completing execution or may throw a checked excetption.
    ```
    Callable<Integer> task = new Callable<Integer>() {
        public Integer call() throws Exception {
            return 100;
        }
    };
    
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Integer> future = executor.submit(task);
    
    try {
        Integer result = future.get(); // block until task done
        System.out.println("Result: " + result);
        
    } catch (InterruptedException ex) {
        // Raised when the thread calling the future.get() method is interrupted before a result can be returned.
        
    } catch (ExecutionException ex) {
        // Rasied when an exception was thrown during the execution of Callable's call() method.
    }
    ```
