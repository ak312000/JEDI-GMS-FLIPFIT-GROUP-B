package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDao {
    static List<Admin> admins = new ArrayList<>();

    public void add(Admin admin) {
        admins.add(admin);
        System.out.println("Admin added successfully");
    }

    public List<Admin> getAllAdmins() {
        // Your database logic to fetch all admins goes here
        // For example, you might use JDBC or an ORM framework

        // For demonstration purposes, let's create a sample list of admins
        if(admins.isEmpty()){
            System.out.println("It is empty");
        }
        return admins;
    }
}
