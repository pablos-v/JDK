package Lec5;

public class task implements Runnable{
    Integer aaa;
    int www;

    public task(Integer aaa) {
        this.aaa = aaa;
        this.www = 0;
    }

    @Override
    public void run() {
        synchronized (task.class) {
            while (www < 10000){
                www++;
                aaa++;
            }
        }
        System.out.println("aaa = " + www + " ccc = " + aaa);
    }
}
