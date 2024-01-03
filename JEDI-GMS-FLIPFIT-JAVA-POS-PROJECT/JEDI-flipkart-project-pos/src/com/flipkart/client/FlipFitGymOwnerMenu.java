package com.flipkart.client;

import com.flipkart.business.FlipFitGymOwnerService;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class FlipFitGymOwnerMenu {

    public void gymOwnerApplicationMenu() {


        boolean opt = true;


        while (opt) {
            System.out.println("Welcome to the Gym Owner Menu");
            System.out.println("\t\t\t1.) Register Gyms");
            System.out.println("\t\t\t2.) View Gyms");
            System.out.println("\t\t\t3.) Edit Gym Details");


            System.out.println("\t\t\t4.) Updated Gym Slot Details");

            System.out.println("\t\t\t5.) Exit");
            System.out.println("Enter the choice you want to perform:");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Register your gym owner");
                    break;
                case 2:
                    System.out.println("View your gyms here");
                    break;
                case 3:
                    System.out.println("Edit Gym Details");
                    break;
                case 4:
                    System.out.println("Updated Gym Slot Details");
                    break;
                default:
                    opt = false;
                    break;
            }
        }

    }

}
