package com.tamco.concurrency;

/**
 * Created by TamCO on 1/17/18.
 */
public class Interrupt {

    public static void main(String[] args) {
        Runnable sleep = new Runnable() {
            @Override
            public void run() {
                System.out.println("I am so lazy, and I am going to sleep for 10 seconds!");

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Someone wakes me up by sending an interrupt. So annoying!");
                }

                System.out.println("It's time for work!");
            }
        };

        Thread thread = new Thread(sleep);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
