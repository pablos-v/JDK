package Sem4;

import java.text.DecimalFormat;

public class Program {
    public static void main(String[] args) {
//        Task_1 lst = new Task_1();
//        lst.add("Adam");
//        lst.add("Sofia");
//        lst.add("Aly");
//        lst.add("Aly");
//
//        lst.sortABC();
//        System.out.println(lst);
//
//        lst.sortByLength();
//        System.out.println(lst);
//
//        lst.revert();
//        System.out.println(lst);
//
//        lst.showUnic();
//        lst.findLowest();
//        lst.findBiggest();
//        lst.delByLetter('A');
//        System.out.println(lst);

        Task_3 dict = new Task_3();
        dict.addEntry(88002000600f, "Avon");
        dict.addEntry(12356798765f, "Horse");
        dict.addEntry(77777777777f, "Casino");

        dict.findSmallest();
        DecimalFormat dF = new DecimalFormat( "#.###" );
        System.out.print(dF.format(dict.findBiggestName()));

    }
}
