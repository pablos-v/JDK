package Sem5.task2;

public class TreadB extends Thread {
    CommonResourse sw;
    int counter = 100;

    public TreadB(CommonResourse sw) {
        this.sw = sw;
    }

    @Override
    public void run() {
        while (counter > -1) {
            if (sw.getSwitcher()) {
                System.out.println(counter--);
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
