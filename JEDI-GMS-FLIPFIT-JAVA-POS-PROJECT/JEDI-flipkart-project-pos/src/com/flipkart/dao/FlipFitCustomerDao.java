package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class FlipFitCustomerDao {
    List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
        System.out.println("Customer data successfully added");
    }
}
