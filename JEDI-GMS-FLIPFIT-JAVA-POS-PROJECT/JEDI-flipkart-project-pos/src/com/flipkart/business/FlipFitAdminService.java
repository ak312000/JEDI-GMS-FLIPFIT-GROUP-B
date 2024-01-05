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

    public void createAdmin( String name, String emailAddress, String phone, String password) {
        Admin admin = new Admin(name,emailAddress,phone,password);
        adminDatabase.add(admin);

    }
    public boolean isValidAdminCredentials( String email, String password) {
        List<Admin> allAdmins = adminDatabase.getAllAdmins();


        for (Admin admin : allAdmins) {
            if (admin.getAdminEmailAddress().equals(email) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void viewAllGymOwners() {

        List<GymOwner> gymOwnerDetails = gymOwnerDao.getAllGymOwners();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-7s %-15s %-13s %-16s %-12s %12s %n", "Owner ID", "Email", "Name", "Address", "GST Number", "Approved");
        System.out.println("------------------------------------------------------------------");

// Assuming gymOwnersList is a list of GymOwner objects
        List<GymOwner> gymOwnersList = gymOwnerDao.getAllGymOwners();

        for (GymOwner gymOwner : gymOwnersList) {
            System.out.printf("%-7d %-15s %-13s %-16s %-12d %12s %n",
                    gymOwner.getOwnerId(),
                    gymOwner.getOwnerEmailAddress(),
                    gymOwner.getOwnerName(),
                    gymOwner.getOwnerAddress(),
                    gymOwner.getOwnerGSTNum(),
                    gymOwner.isApproved());
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

    public void approveGymOwner() {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the GymOwner id: ");
        Integer id = in.nextInt();
        gymOwnerDao.approve(id);
        System.out.println("Gym Owner Approved Successfully with ID: "+id);
    }

    public void approveGymCentre() {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the GymCentre id: ");
        Integer id = in.nextInt();
        gymCentreDao.approve(id);
        System.out.println("Gym Centre Approved Sucessfully with ID:"+id);
    }
}