package com.flipkart.client;

import com.flipkart.business.FlipFitCustomerService;

import java.util.Scanner;

public class FlipFitCustomerMenu {

    public void customerApplicationMenu() {


        boolean opt = true;
        while (opt) {
            System.out.println("Welcome to the Customer Menu");
            System.out.println("\t\t\t1.) View Profile");
            System.out.println("\t\t\t2.) Book a slot");
            System.out.println("\t\t\t3.) cancel a slot");
            System.out.println("\t\t\t4.) Exit");
            System.out.println("Enter the choice you want to perform:");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("This is your profile");
                    break;
                case 2:
                    System.out.println("Directing to book a slot");
                    break;
                case 3:
                    System.out.println("Cancel a slot");
                    break;
                default:
                    opt = false;
                    break;
            }
        }

    }


//                FlipFitCustomerService customerService=new FlipFitCustomerService();
//        customerService.createCustomer();
//        System.out.println(customerService.updateCustomer(101));
//        System.out.println(customerService.deleteCustomer(101));
//        customerService.listCustomer();}


}
