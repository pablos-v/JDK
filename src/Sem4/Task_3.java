package Sem4;

import java.util.*;

/*
● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
● Найдите человека с самым маленьким номером телефона
● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
*/
public class Task_3 {
    private final HashMap<Float, String> yellowPages;

    public Task_3() {
        this.yellowPages = new HashMap<>();
    }

    public HashMap<Float, String> getYellowPages() {
        return yellowPages;
    }

    public void addEntry(Float phone, String name) {
        if (yellowPages.get(phone) != null) System.out.println("Number already exists!");
        else yellowPages.put(phone, name);
    }

    public void findSmallest() {
        System.out.println(yellowPages.get(Collections.min(yellowPages.keySet())));
    }

    public Float findBiggestName() {
        ArrayList<String> arr = new ArrayList<>(yellowPages.values());
        Collections.sort(arr);
        String value = arr.get(arr.size() - 1);
        for (Map.Entry<Float, String> entry : yellowPages.entrySet()) {
            if (entry.getValue().equals(value)) return entry.getKey();
        }
        return 0f;
    }

}
