package com.trieunt.Models;

public class Customer {
    private String id;
    private String customerName;
    private String gender;
    private String birthday;
    private String idCard;
    private String phone;
    private String email;
    private String typeCustomer;
    private String address;
    private Service service;

    public Customer() {
    }

    public Customer(String id, String customerName, String gender, String birthday, String idCard, String phone, String email,
                    String typeCustomer, String address) {
        this.id = id;
        this.customerName = customerName;
        this.gender = gender;
        this.birthday = birthday;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public void showInfo() {
        System.out.printf("%-10s | %-20s | %-12s | %-12s | %-12s | %-20s | %-12s | %-12s%n",
                this.getId(), this.getCustomerName(), this.getBirthday(), this.getIdCard(),
                this.getPhone(), this.getEmail(), this.getTypeCustomer(), this.getAddress());
    }
}
