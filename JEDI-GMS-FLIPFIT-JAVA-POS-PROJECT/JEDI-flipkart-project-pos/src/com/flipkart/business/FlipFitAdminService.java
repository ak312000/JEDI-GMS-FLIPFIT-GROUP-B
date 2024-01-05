package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitAdminDao;
import com.flipkart.dao.FlipFitGymCentreDao;
import com.flipkart.dao.FlipFitGymOwnerDao;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlipFitAdminService {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
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
            List<GymOwner> gymOwnersList = gymOwnerDao.getAllGymOwners();

            if (gymOwnersList.isEmpty()) {
                System.out.println("No gym owners available.");
            } else {
                System.out.println("+--------+--------------------------------+----------------------+--------------------------------+------------+----------+");
                System.out.printf("| %-6s | %-30s | %-20s | %-30s | %-10s | %-8s |%n",
                        "Owner ID", "Email Address", "Owner Name", "Owner Address", "GST Number", "Approved");
                System.out.println("+--------+--------------------------------+----------------------+--------------------------------+------------+----------+");
                for (GymOwner gymOwner : gymOwnersList) {
                    System.out.printf("| %-8d | %-30s | %-20s | %-30s | %-10d | %-8s |%n",
                            gymOwner.getOwnerId(),
                            gymOwner.getOwnerEmailAddress(),
                            gymOwner.getOwnerName(),
                            gymOwner.getOwnerAddress(),
                            gymOwner.getOwnerGSTNum(),
                            gymOwner.isApproved());
            }
                System.out.println("+--------+--------------------------------+----------------------+--------------------------------+------------+----------+");
        }}

    public void viewAllPendingGymOwners() {
        List<GymOwner> gymOwnerDetails = gymOwnerDao.viewPendingGymOwnerRequests();

        if (gymOwnerDetails.isEmpty()) {
            System.out.println("No pending gym owner requests.");
        } else {
            printTableHeader();
            for (GymOwner owner : gymOwnerDetails) {
                printTableRow(owner);
            }
            printTableFooter();
        }
    }

    private void printTableHeader() {
        System.out.println("+-------------------+--------------+------------------------+--------------+----------+----------+------");
        System.out.printf("| %-19s | %-13s | %-24s | %-17s | %-15s |%n",
                "Email", "Name", "Aadhaar Number", "GST Number", "Approved");
        System.out.println("+-------------------+--------------+------------------------+--------------+----------+----------+------");
    }

    private void printTableRow(GymOwner owner) {
        System.out.printf("| %-19s | %-13s | %-24s | %-17s | %-15s |%n",
                owner.getOwnerEmailAddress(),
                owner.getOwnerName(),
                owner.getOwnerAddress(),
                owner.getOwnerGSTNum(),
                owner.isApproved() ? "Yes" : "No");
    }

    private void printTableFooter() {
        System.out.println("+-------------------+--------------+------------------------+--------------+----------+----------+-------");
    }


    public void viewAllGyms() {
        List<GymCenter> gymDetails = gymCentreDao.getGymCenters();

        if (gymDetails.isEmpty()) {
            System.out.println("No gyms available.");
        } else {
            System.out.println("+----------------+--------------+-----------------------+----------+");
            System.out.printf("| %-13s | %-11s | %-20s | %-8s |%n", "Gym Id", "Name", "Address", "Approved");
            System.out.println("+----------------+--------------+-----------------------+----------+");

            for (GymCenter gym : gymDetails) {
                System.out.printf("| %-13s | %-11s | %-20s | %-8s |%n",
                        gym.getId(),
                        gym.getGymName(),
                        gym.getGymLocation(),
                        gym.isApproved() ? "Yes" : "No");
            }

            System.out.println("+----------------+--------------+-----------------------+----------+");
        }
    }
    public void viewPendingGymCentres() {
        List<GymCenter> gymDetails = gymCentreDao.viewPendingGymCentreRequests();

        if (gymDetails.isEmpty()) {
            System.out.println("No pending gym requests.");
        } else {
            System.out.println("+----------------+--------------+------------------+----------+");
            System.out.printf("| %-13s | %-11s | %-16s | %-8s |%n", "Gym Id", "Name", "Address", "Approved");
            System.out.println("+----------------+--------------+------------------+----------+");

            for (GymCenter gym : gymDetails) {
                System.out.printf("| %-13s | %-11s | %-25s | %-10s |%n",
                        gym.getId(),
                        gym.getGymName(),
                        gym.getGymLocation(),
                        gym.isApproved() ? "Yes" : "No");
            }

            System.out.println("+----------------+--------------+------------------+----------+");
        }
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