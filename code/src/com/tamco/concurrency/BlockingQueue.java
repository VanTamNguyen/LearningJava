package com.tamco.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TamCO on 1/10/18.
 *
 * This class illustrates the way wait(), notify() and notifyAll() working
 */
public class BlockingQueue {

    // This is the blocking queue
    private List<String> queue = new ArrayList<>();

    // This is the size of the queue
    private final int size = 1;

    public BlockingQueue() {
    }

    public void enqueue(String item) {
        synchronized (queue) {
            while (queue.size() == size) {
                try {
                    System.out.println("Queue full, wait until someone dequeue some items to get the space to enqueue\n**********************************************************");
                    queue.wait();
                } catch (InterruptedException e) {
                    // What should I do here? Someone interrupts me.
                }
            }

            queue.add(item);
            queue.notify();
        }
    }

    public String dequeue() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    System.out.println("Queue empty, wait until someone adds some items to dequeue\n**********************************************************");
                    queue.wait();
                } catch (InterruptedException e) {
                    // What should I do here? Someone interrupts me.
                }
            }

            queue.notify();
            return queue.remove(0);
        }
    }

    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                long count = 0;

                while (true) {
                    String item = "Item " + count;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // What should I do? Nothing
                    }

                    queue.enqueue(item);

                    count++;
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // What should I do? Nothing
                    }

                    String item = queue.dequeue();
                    System.out.println("Handle " + item + "\n**********************************************************");
                }
            }
        };


        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);
        producerThread.start();
        consumerThread.start();
    }
}
