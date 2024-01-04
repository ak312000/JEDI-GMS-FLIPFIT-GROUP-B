package com.flipkart.dao;

import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

public class FlipFitCustomerDao {
    static List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
        System.out.println("Customer data successfully added");
    }

    public List<Customer> getAllCustomers() {

        return customers;
    }
    public static Customer getCustomerById(Integer customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;  // Customer not found with the specified ID
    }
    public void updateCustomer(Customer updatedCustomer) {
        int updatedCustomerId = updatedCustomer.getCustomerId();

        for (int i = 0; i < customers.size(); i++) {
            Customer existingCustomer = customers.get(i);
            if (existingCustomer.getCustomerId() == updatedCustomerId) {
                // Update the existing customer with the new details
                customers.set(i, updatedCustomer);
                // Exit the loop once the customer is updated
            }
        }
        // Optionally, you may want to save the updated list to your data source (e.g., database).
    }


}
