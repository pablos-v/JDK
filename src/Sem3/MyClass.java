package Sem3;

import java.io.DataInput;
import java.io.InputStream;

public class MyClass<T extends Comparable<String>, V extends InputStream & DataInput, K extends Number> {
    private T one;
    private V two;
    private K three;

    public MyClass(T one, V two, K three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    //region Getters/Setters
    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public V getTwo() {
        return two;
    }

    public void setTwo(V two) {
        this.two = two;
    }

    public K getThree() {
        return three;
    }

    public void setThree(K three) {
        this.three = three;
    }
    //endregion

    public void printNames() {
        System.out.println(one.getClass().getSimpleName() + " " + two.getClass().getSimpleName() +
                " " + three.getClass().getSimpleName());
    }


}
