package Sem4;

import java.util.*;

/*
● Создайте коллекцию мужских и женских имен с помощью интерфейса List
● Отсортируйте коллекцию в алфавитном порядке
● Отсортируйте коллекцию по количеству букв в слове
● Разверните коллекцию
● Получите уникальный список Set на основании List
● Определите наименьший элемент (алфавитный порядок)
● Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
● Удалите все элементы содержащие букву ‘A’

*/
public class Task_1 implements List {
    public List<String> names;

    public Task_1() {
        this.names = new ArrayList<>();
    }

    public void sortABC() {
        Collections.sort(names);
    }

    public void sortByLength() {
//        names.sort(new Comparedo());
        names.sort(Comparator.comparingInt(String::length));
    }

    public void findLowest() {
        Collections.sort(names);
        System.out.println(names.get(0));
    }

    public void findBiggest() {
        sortByLength();
        System.out.println(names.get(names.size() - 1));
    }

    public void revert() {
        Collections.reverse(names);
    }

    @Override
    public int size() {
        return 0;
    }

    public void showUnic() {
        System.out.println(new HashSet<>(names));
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder ress = new StringBuilder();
        for (String name : names) {
            ress.append(name).append(" ");
        }
        return ress.toString();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        try {
            names.add((String) o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        names = new ArrayList<>();
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public void delByLetter(char a) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).contains(a + "")) names.remove(i--);
        }
    }
}
