package Sem5;

public class Friend {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend friend) {
        System.out.println(name + ": Я поклонился " + friend.getName());
        friend.bowBack(this);
    }

    public synchronized void bowBack(Friend friend) {
        System.out.println(name + ": Я кланяюсь " + friend.getName() + " в ответ");
    }

}
