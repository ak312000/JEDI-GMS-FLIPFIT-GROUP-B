//package com.flipkart.client;
//
//import com.flipkart.business.FlipFitGymOwnerService;
//import org.w3c.dom.ls.LSOutput;
//
//import java.util.Scanner;
//
//public class FlipFitGymOwnerMenu {
//
//    public void gymOwnerApplicationMenu() {
//
//
//        boolean opt = true;
//
//
//        while (opt) {
//            System.out.println("Welcome to the Gym Owner Menu");
//            System.out.println("\t\t\t1.) Register Gyms");
//            System.out.println("\t\t\t2.) View Gyms");
//            System.out.println("\t\t\t3.) Edit Gym Details");
//
//
//            System.out.println("\t\t\t4.) Updated Gym Slot Details");
//
//            System.out.println("\t\t\t5.) Exit");
//            System.out.println("Enter the choice you want to perform:");
//            Scanner in = new Scanner(System.in);
//            int choice = in.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("Register your gym owner");
//                    break;
//                case 2:
//                    System.out.println("View your gyms here");
//                    break;
//                case 3:
//                    System.out.println("Edit Gym Details");
//                    break;
//                case 4:
//                    System.out.println("Updated Gym Slot Details");
//                    break;
//                default:
//                    opt = false;
//                    break;
//            }
//        }
//
//    }
//
//}
package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.business.FlipFitGymOwnerService;

/**
 *
 */
public class FlipFitGymOwnerMenu {
    FlipFitGymOwnerService gymOwner = new FlipFitGymOwnerService();
    FlipFitGymOwnerService flipFitGymOwnerService = new FlipFitGymOwnerService();
    public void login(String email,String password){
        Scanner in = new Scanner(System.in);
        if (flipFitGymOwnerService.isValidGymOwnerCredentials(email, password)) {
            System.out.println("Login successful!");
            gymOwnerMenu();
        } else {
            System.out.println("Invalid credentials. Login failed. Please Try again.....");
        }


    }
    public void register(String email,String password){

        flipFitGymOwnerService.createGymOwner(email,password);
        gymOwnerMenu();
    }

    public void gymOwnerMenu() {




        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("1. Gym Registration");
            System.out.println("2. Add new slots");
            System.out.println("3. View Registered Gyms");
            System.out.println("4. View Registered and free slots");
            System.out.println("5. Edit Gym details");
            System.out.println("6. Edit slots");
            System.out.println("7. Edit Profile");
            System.out.println("8. Exit");
            int op1 = in.nextInt();
            switch (op1) {
                case 1:
                    gymOwner.registerGymCenter();
                    break;
                case 2:
                    gymOwner.addSlots();
                    break;
                case 3:
                    gymOwner.viewAllApprovedGymCenters();
                    break;
                case 4:
                    gymOwner.viewAllSlots();
                    break;
                case 5:
                    gymOwner.editGym();
                    break;
                case 6:
                    gymOwner.editSlots();
                    break;
                case 7:
                    gymOwner.editProfile();
                    break;
                default:
                    System.out.println("Exit");
                    FlipFitApplicationMenu.mainPage();
                    break;
            }

        }
}}
