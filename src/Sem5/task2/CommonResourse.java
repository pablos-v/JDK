package Sem5.task2;

public class CommonResourse {
    private volatile boolean switcher; // false by default

    public boolean getSwitcher() {
        return switcher;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }
}
