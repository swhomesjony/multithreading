package com.sjony.study;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    //方法启动
//    public static void main(String[] args) throws Exception {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        MyRunnable myRunnable = new MyRunnable();
//        myRunnable.run();
//        MyCallable myCallable = new MyCallable();
//        myCallable.call();
//    }

    static MyThread1 t1 = new MyThread1();
    static MyThread2 t2 = new MyThread2();
    static MyThread3 t3 = new MyThread3();



    public static void main(String[] args) throws Exception {
        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread1 extends Thread {

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t2.notify();
            System.out.println(1);
        }
    }

    static class MyThread2 extends Thread {

        public void run() {
            try {
                t2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
            t3.notify();
        }
    }

    static class MyThread3 extends Thread {

        public void run() {
            try {
                t3.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
        }
    }

}
