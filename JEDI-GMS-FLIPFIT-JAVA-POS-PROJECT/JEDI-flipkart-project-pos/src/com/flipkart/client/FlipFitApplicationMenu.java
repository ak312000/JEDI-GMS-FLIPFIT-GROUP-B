package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitCustomerService;

import java.nio.Buffer;
import java.util.Scanner;

public class FlipFitApplicationMenu {
    public static void mainPage()  {
        boolean flag = true;
        while (flag) {
            System.out.println("Welcome to FlipFit Application");

            Scanner in = new Scanner(System.in);
            System.out.println("Enter the EmailId: ");
            String email = in.next();
            System.out.println("Enter the Password: ");
            String password = in.next();
            System.out.println("Enter the role: ");
            System.out.println("\tPress 1 For Admin");
            System.out.println("\tPress 2 For Customer");
            System.out.println("\tPress 3 For gymowner");
            System.out.println("\tPress any other key For Exit");

            int role = in.nextInt();

            if (role==1) {
                System.out.println("Welcome to Admin Menu");
                FlipFitAdminApplicationMenu admin = new FlipFitAdminApplicationMenu();
                int choice = index();
                switch (choice) {
                    case 1:
                        admin.Login(email, password);
                        break;
                    case 2:
                        admin.register(email, password);
                        break;
                    case 3:
                        FlipFitApplicationMenu.mainPage();
                        break;
                    default:
                        System.out.println("Incorrect choice");
                        break;
                }
            } else if (role==2) {
                System.out.println("Welcome to Customer Menu");
                FlipFitCustomerMenu customer = new FlipFitCustomerMenu();

                int choice = index();
                switch (choice) {
                    case 1:
                        customer.login(email,password);
                        break;
                    case 2:
                        customer.register(email,password);
                        break;
                    case 3:
                        FlipFitApplicationMenu.mainPage();
                        break;
                    default:
                        System.out.println("Incorrect choice");
                        break;
                }
            } else if (role==3) {
                FlipFitGymOwnerMenu gymOwner = new FlipFitGymOwnerMenu();
                int choice = index();
                switch (choice) {
                    case 1:
                        gymOwner.login(email,password);
                        break;
                    case 2:
                        gymOwner.register(email,password);
                        break;
                    case 3:
                        mainPage();
                        break;
                    default:
                        System.out.println("Incorrect choice");
                        break;
                }
            } else {
                System.out.println("Please Enter valid role");
                flag=false;
            }
        }
    }

    public static int index(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        Scanner in =  new Scanner(System.in);
        int choice = in.nextInt();
        return choice;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlipFitApplicationMenu.mainPage();
    }

}