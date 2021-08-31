package com.test.leetcode;

public class ALternatePrintingThread {

    private static Object lockO = new Object();
    private static int a = 1;

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("jishu thread");
            synchronized (lockO) {
                while (true) {
                    if (a > 10) {
                        lockO.notify();
                    } else {
                        if (a % 2 == 1) {
                            System.out.println(a++);
                            lockO.notify();
                            try {
                                lockO.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            try {
                                lockO.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("oushu thread");
            synchronized (lockO) {
                while (true) {
                    if (a > 10) {
                        lockO.notify();
                    } else {
                        if (a % 2 == 0) {
                            System.out.println(a++);
                            lockO.notify();
                            try {
                                lockO.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();


        try {
            Object a = new Object();
            synchronized (a){
                a.wait(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
