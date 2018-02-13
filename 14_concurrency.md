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
* [Coding example](code/src/com/tamco/concurrency/AtomicExample.java)

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


#### 3. Concurrent Collections
* **Copy-On-Write Collections** 


#### 4. Executors and ThreadPool
