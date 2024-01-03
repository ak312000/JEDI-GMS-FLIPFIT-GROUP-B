package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitAdminDao;

import java.util.Arrays;
import java.util.List;

public class FlipFitAdminService {
    FlipFitAdminDao adminDatabase = new FlipFitAdminDao();
    Admin admin = new Admin();

    public void createAdmin(int id, String name, String emailAddress, int phone, String password) {

        admin.setAdminEmailAddress(emailAddress);
        admin.setAdminName(name);
        admin.setAdminId(id);
        admin.setAdminPhone(phone);
        admin.setPassword(password);
        adminDatabase.add(admin);

        System.out.println("admin details added");
    }

    public List<GymCenter> viewPendingGymRequests(){
        return Arrays.asList();
    }

    public List<GymOwner> viewPendingGymOwnerRequests(int id) {
        System.out.println("view Pending Gym Owner Requests");
        return Arrays.asList();
    }

    public boolean approveGymOwnerRegistration(int id) {
        System.out.println("approve Gym Owner Registration");
        return true;
    }

    public List<GymOwner> viewAllApprovedGymOwners() {
        System.out.println("view All Approved Gym Owners");
        return Arrays.asList();
    }

    public List<GymCenter> viewAllApprovedGyms() {
        System.out.println("view All Approved Gyms");
        return Arrays.asList();
    }
}