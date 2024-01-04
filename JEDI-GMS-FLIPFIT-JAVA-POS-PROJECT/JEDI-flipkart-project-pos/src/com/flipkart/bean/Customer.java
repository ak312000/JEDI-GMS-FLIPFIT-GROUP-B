package com.flipkart.bean;

public class Customer {
    private static int startId=100;
    private int customerId;
    private String customerName;
    private String customerAddress;
    private String customerEmailAddress;
    private String customerPhone;
    private String password;

    public Customer(String name, String address, String emailAddress, String phone, String password) {
        this.customerId=startId++;
        this.customerName=name;
        this.customerEmailAddress=emailAddress;
        this.customerPhone=phone;
        this.customerAddress=address;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public String getCustomerEmailAddress() {
        return customerEmailAddress;
    }
    public void setCustomerEmailAddress(String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
}
