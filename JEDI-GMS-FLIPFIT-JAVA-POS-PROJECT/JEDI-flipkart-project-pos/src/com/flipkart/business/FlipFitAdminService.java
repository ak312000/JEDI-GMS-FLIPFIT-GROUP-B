package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitAdminDao;
import com.flipkart.dao.FlipFitGymCentreDao;
import com.flipkart.dao.FlipFitGymOwnerDao;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlipFitAdminService {
    FlipFitAdminDao adminDatabase = new FlipFitAdminDao();
    FlipFitGymOwnerDao gymOwnerDao = new FlipFitGymOwnerDao();
    FlipFitGymCentreDao gymCentreDao = new FlipFitGymCentreDao();

    public void createAdmin(int id, String name, String emailAddress, String phone, String password) {
        Admin admin = new Admin();

        admin.setAdminEmailAddress(emailAddress);
        admin.setAdminName(name);
        admin.setAdminId(id);
        admin.setAdminPhone(phone);
        admin.setPassword(password);
        adminDatabase.add(admin);

//        System.out.println("admin details added");
    }
    public boolean isValidAdminCredentials( String email, String password) {
        List<Admin> allAdmins = adminDatabase.getAllAdmins();
        // Check if the entered credentials match any of the admins in the list
        System.out.println("reached here");

        for (Admin admin : allAdmins) {
            System.out.println("email"+admin.getAdminEmailAddress());
            System.out.println("pass"+admin.getPassword());
            if (admin.getAdminEmailAddress().equals(email) && admin.getPassword().equals(password)) {
                return true; // Credentials are valid
            }
        }
        return false; // No matching admin found
    }

    public void viewAllGymOwners() {

        List<GymOwner> gymOwnerDetails = gymOwnerDao.getAllGymOwners();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-15s %-13s %-16s %-12s %12s %n", "Email", "Name", "Address", "GST Number", "Approved");
        System.out.println("------------------------------------------------------------------");
        for(GymOwner owner: gymOwnerDetails) {

            System.out.printf("%-16s", owner.getOwnerEmailAddress());
            System.out.printf("%-16s", owner.getOwnerName());
            System.out.printf("%-16s", owner.getOwnerAddress());
            System.out.printf("%-18s", owner.getOwnerGSTNum());
            if(owner.isApproved())
            {
                System.out.printf("%-18s", "Yes");
            }
            else
            {
                System.out.printf("%-18s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    public void viewAllPendingGymOwners() {
        // TODO Auto-generated method stub
        List<GymOwner> gymOwnerDetails = gymOwnerDao.viewPendingGymOwnerRequests();

        System.out.printf("%-19s %-13s %-24s %-17s %-15s %n", "Email", "Name", "Aadhaar Number", "GST Number", "Approved");
        for(GymOwner owner: gymOwnerDetails) {
            System.out.printf("%-16s\t", owner.getOwnerEmailAddress());
            System.out.printf("%-16s\t", owner.getOwnerName());
            System.out.printf("%-16s\t", owner.getOwnerAddress());
            System.out.printf("%-16s\t", owner.getOwnerGSTNum());
            if(owner.isApproved())
            {
                System.out.printf("%-16s\t", "Yes");
            }
            else
            {
                System.out.printf("%-16s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGyms() {
        // TODO Auto-generated method stub
        List<GymCenter> gymDetails = gymCentreDao.getGymCenters();

        System.out.printf("%-16s %-13s %-11s %16s %n", "Gym Id", "Name", "Address", "Approved");
        for(GymCenter gym: gymDetails) {
            System.out.printf("%-16s", gym.getId());
            System.out.printf("%-16s", gym.getGymName());
            System.out.printf("%-20s", gym.getGymLocation());
            if(gym.isApproved())
            {
                System.out.printf("%-20s", "Yes");
            }
            else
            {
                System.out.printf("%-20s", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewPendingGymCentres() {
        // TODO Auto-generated method stub
        List<GymCenter> gymDetails = gymCentreDao.viewPendingGymCentreRequests();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-16s %-13s %-16s %-16s %n", "Gym Id","Name", "Address", "Approved");
        System.out.println("--------------------------------------------------------");
        for(GymCenter gym: gymDetails) {
            System.out.printf("%-16s", gym.getId());
            System.out.printf("%-16s", gym.getGymName());
            System.out.printf("%-16s", gym.getGymLocation());
            if(gym.isApproved()){
                System.out.printf("%-16s", "Yes");
            }
            else
            {
                System.out.printf("%-16s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }





    public boolean approveGymOwnerRegistration(int id) {
        System.out.println("approve Gym Owner Registration");
        return true;
    }

    public List<GymOwner> viewAllApprovedGymOwners() {

        adminDatabase.getAllAdmins();
        return Arrays.asList();
    }

    public List<GymCenter> viewAllApprovedGyms() {
        System.out.println("view All Approved Gyms");
        return Arrays.asList();
    }
}