package com.flipkart.dao;

import com.flipkart.bean.Admin;

import java.util.ArrayList;
import java.util.List;

public class FlipFitAdminDao {
    List<Admin> admins = new ArrayList<>();

    public void add(Admin admin) {
        admins.add(admin);
        System.out.println("Admin data successfully added");
    }
}
