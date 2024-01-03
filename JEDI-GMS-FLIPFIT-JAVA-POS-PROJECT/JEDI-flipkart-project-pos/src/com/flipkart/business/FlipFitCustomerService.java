package com.flipkart.business;

public class FlipFitCustomerService {
    public void createCustomer()
    {
        System.out.println("customer is created");
    }

    public boolean deleteCustomer(Integer id)
    {
        System.out.println("customer is deleted");

        return true;
    }

    public boolean updateCustomer(Integer id)
    {
        System.out.println("customer is updated");

        return true;
    }

    public void listCustomer()
    {
        System.out.println("customer list");
    }

}
