package Lec3_Jenerics;

public class Program {
    public static void main(String[] args) {
        TBOX<Animal> n1 = new TBOX<>();
        n1.setValue(new Animal("qwer"));
        TBOX.printInfo(n1);
        n1 = TBOX.emptyBox();
        TBOX.printInfo(n1);

        n1.setValue(new Dog("asdf"));
        TBOX.printInfo(n1);

        n1.setValue(new Cat("zxcv"));
        TBOX.printInfo(n1);



    }
}
