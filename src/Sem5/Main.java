package Sem5;

public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Nick");
        Friend friend2 = new Friend("Egor");

        MyThread tread = new MyThread(friend1, friend2);
        MyThread tread2 = new MyThread(friend2, friend1);

        tread.start();
        tread2.start();
    }
}

