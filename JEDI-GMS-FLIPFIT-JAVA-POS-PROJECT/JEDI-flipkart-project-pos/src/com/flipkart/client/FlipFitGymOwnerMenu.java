package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerService;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FlipFitGymOwnerMenu {

    public void gymOwnerApplicationMenu() {


        boolean opt = true;


        while (opt) {
            System.out.println("Welcome to the Gym Owner Menu");
            System.out.println("\t\t\t1.) Manage Gyms");
            System.out.println("\t\t\t2.) Manage slots");
            System.out.println("\t\t\t3.) Exit");
            System.out.println("Enter the choice you want to perform:");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You are in gym management");
                    break;
                case 2:
                    System.out.println("You are in slot management");
                    break;
                default:
                    opt = false;
                    break;
            }
        }
//                FlipFitGymOwnerService gymOwnerService = new FlipFitGymOwnerService();
//                gymOwnerService.createGymOwner();
//                System.out.println(gymOwnerService.updateGymOwner(101));
//                System.out.println(gymOwnerService.deleteGymOwner(101));
//                gymOwnerService.listGymOwner();
    }

}
