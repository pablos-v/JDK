package Lec3_Jenerics;

public class TBOX<T> {
    public static final TBOX EMPTY_BOX = new TBOX<>();
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    static <T> TBOX<T> emptyBox() {
        return (TBOX<T>) EMPTY_BOX;
    }

//    static void printInfo(TBOX<? extends Animal> animal){
//        System.out.println(animal);
//    }

    static void printInfo(TBOX<?> animal){
        System.out.println(animal);
    }

    @Override
    public String toString() {
        return value == null? "No one" : value.toString();
    }
}
