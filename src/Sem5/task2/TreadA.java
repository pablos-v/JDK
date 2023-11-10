package Sem5.task2;

public class TreadA extends Thread {
    CommonResourse sw;

    public TreadA(CommonResourse sw) {
        this.sw = sw;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sw.setSwitcher(!sw.getSwitcher());
    }
}
