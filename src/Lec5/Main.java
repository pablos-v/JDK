package Lec5;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer ccc = 0;
        task task = new task(ccc);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(ccc);

    }
}
