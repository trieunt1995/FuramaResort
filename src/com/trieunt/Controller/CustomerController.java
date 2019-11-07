package com.trieunt.Controller;

import com.trieunt.Commons.NameSortComparator;
import com.trieunt.Commons.ReadWriteToFile;
import com.trieunt.Commons.Validation;
import com.trieunt.Models.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.UUID;

public class CustomerController {
    public static void addNewCustomers() {
        ArrayList<Customer> customerArrayList = ReadWriteToFile.readDataCustomersToFile();
        Customer customer = new Customer();
        customer.setId(UUID.randomUUID().toString().replace("-", ""));

        String contentCustomerName = "Enter name customer: ";
        System.out.print(contentCustomerName);
        customer.setCustomerName(new Scanner(System.in).nextLine());
        while (!Validation.checkName(customer.getCustomerName())) {
            System.out.println("Error: The name customer is not valid. Please enter again!");
            System.out.print(contentCustomerName);
            customer.setCustomerName(new Scanner(System.in).nextLine());
        }

        String contentBirthday = "Enter birthDay of Customer (Ex:22/09/1976): ";
        System.out.print(contentBirthday);
        customer.setBirthday(new Scanner(System.in).nextLine());
        while (!Validation.checkDate(customer.getBirthday())) {
            System.out.println("Error: The birthday customer is not valid. Please enter again!");
            System.out.print(contentBirthday);
            customer.setBirthday(new Scanner(System.in).nextLine() );
        }

        System.out.print("Enter gender customer [Male/Female/Unknow]: ");
        customer.setGender(Validation.checkGender(new Scanner(System.in).nextLine()));

        // ID card:
        String contentIdCard = "Enter ID card of customer: ";
        System.out.print(contentIdCard);
        customer.setIdCard(new Scanner(System.in).nextLine());
        while (!Validation.checkIdCard(customer.getIdCard())){
            System.out.println("The ID card of customer is not valid. Please enter again!");
            System.out.println(contentIdCard);
            customer.setIdCard(new Scanner(System.in).nextLine());
        }

        String contentPhone = "Enter phone of customer: ";
        System.out.print(contentPhone);
        customer.setPhone(new Scanner(System.in).nextLine());
        while (!Validation.checkPhoneNumber(customer.getPhone())){
            System.out.println("The phone of customer is not valid. Please enter again!");
            System.out.println(contentPhone);
            customer.setPhone(new Scanner(System.in).nextLine());
        }


        // Mail:
        String contentEmail = "Enter email of customer [xxx@xxx.xxx]: ";
        System.out.print(contentEmail);
        customer.setEmail(new Scanner(System.in).nextLine());
        while (!Validation.checkEmail(customer.getEmail())) {
            System.out.println("Error: The email of customer is not valid. Please enter again!");
            System.out.print(contentEmail);
            customer.setEmail(new Scanner(System.in).nextLine());
        }

        String contentTypeCustomer = "Enter the type of customer: ";
        System.out.print(contentTypeCustomer);
        customer.setTypeCustomer(new Scanner(System.in).nextLine());
        while (!Validation.checkName(customer.getTypeCustomer())) {
            System.out.println("Error: The type of customer is not valid. Please enter again!");
            System.out.print(contentTypeCustomer);
            customer.setTypeCustomer(new Scanner(System.in).nextLine());
        }

        String contentAddress = "Enter the address of customer: ";
        System.out.print(contentAddress);
        customer.setAddress(new Scanner(System.in).nextLine());
        while (!Validation.checkName(customer.getAddress())) {
            System.out.println("Error: The address of customer is not valid. Please enter again!");
            System.out.print(contentAddress);
            customer.setAddress(new Scanner(System.in).nextLine());
        }

        customerArrayList.add(customer);
        ReadWriteToFile.writeDataCustomersToFile(customerArrayList);

    }

    public static void showAllCustomers() {
        ArrayList<Customer> listCustomer = ReadWriteToFile.readDataCustomersToFile();
        Collections.sort(listCustomer, new NameSortComparator());
        for (Customer customer : listCustomer) {
            customer.showInfo();
        }
    }
}
