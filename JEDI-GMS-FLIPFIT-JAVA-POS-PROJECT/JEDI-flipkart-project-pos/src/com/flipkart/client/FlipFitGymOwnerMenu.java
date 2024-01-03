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

    public static void gymOwnerMenu() throws Exception {
        // TODO Auto-generated method stub
        FlipFitGymOwnerService gymOwner = new FlipFitGymOwnerService();
        Scanner in = new Scanner(System.in);
        int op1;

        System.out.println("1. Gym Registration");
        System.out.println("2. Add new slots");
        System.out.println("3. View Registered Gyms");
        System.out.println("4. View Registered and free slots");
        System.out.println("5. Edit Gym details");
        System.out.println("6. Edit slots");
        System.out.println("7. Edit Profile");
        System.out.println("8. Exit");

        op1 = in.nextInt();
        if(op1 == 8) {
            FlipFitApplicationMenu gymApplication = new FlipFitApplicationMenu();
            gymApplication.main(null);
        }

		/*
		System.out.println(gymOwner.viewAllSlots(0));
		System.out.println(gymOwner.isApprovedGymOwner(0));
		System.out.println(gymOwner.isApprovedGymCenter());
		System.out.println(gymOwner.createSlot(0));

		gymOwner.addSlots();
		gymOwner.getOwnerDetails();
		gymOwner.addGym(0);
		gymOwner.viewAllApprovedGymCenters();
		gymOwner.viewAllGymCenters();
		*/
    }
}
