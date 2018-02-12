package com.tamco.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by TamCO on 2/12/18.
 */

public class AtomicExample {

    private static final int LOOP = 100000;

    private static AtomicInteger resource = new AtomicInteger(10);

    public static void main(String[] args) throws InterruptedException {
        Runnable increase = () -> {
            for (int i = 0; i < LOOP; i++) {
                resource.getAndIncrement();
            }
        };

        Runnable decrease = () -> {
            for (int i = 0; i < LOOP; i++) {
                resource.getAndDecrement();
            }
        };

        Thread increaseThread = new Thread(increase);
        Thread decreaseThread = new Thread(decrease);

        increaseThread.start();
        decreaseThread.start();

        increaseThread.join();
        decreaseThread.join();

        System.out.println("After several increment and decrement the resource is still: " + resource.intValue());
    }
}
