package Hw4;

public class Employee {
    //region Fields
    private int ID;
    private String phoneNumber;
    private String name;
    private int experience;
    public static int idE = 0;
    //endregion

    public Employee(String phoneNumber, String name, int experience) {
        this.ID = ++idE;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.experience = experience;
    }

    //region Setters-Getters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
    //endregion

    @Override
    public String toString() {
        return "Employee{" +
                "ID=" + ID +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }

    public int getID() {
        return ID;
    }
}
