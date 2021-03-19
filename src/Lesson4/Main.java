package Lesson4;

public class Main {
    static Object lock = new Object();
    static volatile int currentNum = 1;
    static final int count = 5;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentNum != 1) {
                            lock.wait();
                        }
                        System.out.print("A");
                        currentNum = 2;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentNum != 2) {
                            lock.wait();
                        }
                        System.out.print("B");
                        currentNum = 3;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < count; i++) {
                    synchronized (lock) {
                        while (currentNum != 3) {
                            lock.wait();
                        }
                        System.out.print("C");
                        currentNum = 1;
                        lock.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}

