package com.trieunt.Models;

public class Employee {
    /*
    Họ tên Employee ,tuổi , địa chỉ và phương thức toString()
     */
    private String nameEmployee;
    private int age;
    private String address;

    public Employee() {
    }

    public Employee(String nameEmployee, int age, String address) {
        this.nameEmployee = nameEmployee;
        this.age = age;
        this.address = address;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-20d | %-12s%n", this.getNameEmployee(), this.getAge(), this.getAddress());
    }
}
