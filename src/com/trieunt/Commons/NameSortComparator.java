package com.trieunt.Commons;

import com.trieunt.Models.Customer;

import java.util.Comparator;

public class NameSortComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer ct1, Customer ct2) {
        return ct1.getCustomerName().compareTo(ct2.getCustomerName());
    }
}
