package com.cognizant.test;

import com.cognizant.singleton.Logger;

public class SingletonTest {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        System.out.println("First logger reference: " + l1);
        System.out.println("Second logger reference: " + l2);

        if (l1 == l2) {
            System.out.println("Verify: Both references point to the exact same Logger instance!");
        } else {
            System.out.println("Verify: Error, different instances created.");
        }

        l1.log("Writing message using first logger reference.");
        l2.log("Writing message using second logger reference.");

        System.out.println("Starting thread check...");
        Thread t1 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Hello from thread! Logger is: " + threadLogger);
        });

        Thread t2 = new Thread(() -> {
            Logger threadLogger = Logger.getInstance();
            threadLogger.log("Hello from another thread! Logger is: " + threadLogger);
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread got interrupted");
        }
    }
}
