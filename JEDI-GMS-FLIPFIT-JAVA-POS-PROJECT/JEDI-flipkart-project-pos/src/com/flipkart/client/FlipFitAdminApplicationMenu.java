package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitGymOwnerService;

import java.util.Scanner;

public class FlipFitAdminApplicationMenu {

    public void adminApplicationMenu() {
        boolean opt = true;
        while (opt) {
            System.out.println("Welcome to the Admin Menu");

            System.out.println("\t\t\t1.) Manage Customers");
            System.out.println("\t\t\t2.) Manage GymCentre");
            System.out.println("\t\t\t3.) Exit");
            System.out.println("Enter the choice you want to perform:");


            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You are in customer management");
                    break;
                case 2:
                    System.out.println("You are in gym centre management");
                    break;
                default:
                    opt = false;
                    break;
            }
        }
    }
}
