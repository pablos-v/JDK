package Sem3;

import java.util.ArrayList;

public class MyCollection <T> extends ArrayList<T> {
    @Override
    public boolean add(T t) {
        return super.add(t);
    }

    @Override
    public T remove(int index) {
        return super.remove(index);
    }
}
