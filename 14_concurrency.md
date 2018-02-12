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

* Method ```getAndIncrement``` in ```AtomicInteger``` illustrates how atomic classes use CAS for thread safe.
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

#### 2. Locks
