package com.sjony.study;

import java.util.concurrent.Callable;

public class MyThread extends Thread {

    private static boolean ready;
    private static int number;

    public static void main(String[] args) throws Exception {
        MyThread myThread = new MyThread();
        myThread.start();
        MyRunnable myRunnable = new MyRunnable();
        myRunnable.run();
        MyCallable myCallable = new MyCallable();
        myCallable.call();
    }

}
