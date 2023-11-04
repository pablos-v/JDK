package Hw4;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmpDir {

    private final List<Employee> employeeList;

    public EmpDir() {
        this.employeeList = new ArrayList<>();
    }

    public void add(String phoneNumber, String name, int experience) {
        employeeList.add(new Employee(phoneNumber, name, experience));
    }

    public List<Employee> findByExp(int exp) {
        List<Employee> res = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getExperience() == exp) res.add(emp);
        }
        return res;
    }

    public List<String> getPhoneByName(String name){
        List<String> res = new ArrayList<>();
        for (Employee emp: employeeList){
            if (emp.getName().equals(name)) res.add(emp.getPhoneNumber());
        }
        return res;
    }

    public Employee findByID(int ID){
        for (Employee emp: employeeList){
            if (emp.getID()==ID) return emp;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (Employee e:employeeList){
            res.append(e).append("\n");
        }

        return res.toString();
    }
}
