package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitCustomerService;

import java.nio.Buffer;
import java.util.Scanner;

public class FlipFitApplicationMenu {
    public static void mainPage()  {
        System.out.println("Welcome to FlipFit Application");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the username: ");
        String username = in.next();
        System.out.println("Enter the password: ");
        String password = in.next();
        System.out.println("Enter the role: ");
        String role = in.next();

        if(role.equalsIgnoreCase("Admin")){
            System.out.println("Welcome to Admin Menu");
            FlipFitAdminApplicationMenu admin=new FlipFitAdminApplicationMenu();
            int choice = index();
            switch (choice) {
                case 1:
                    admin.Login();
                    break;
                case 2:
                    admin.register();
                    break;
                case 3:
                    FlipFitApplicationMenu.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
        else if(role.equalsIgnoreCase("Customer")){
            System.out.println("Welcome to Customer Menu");
            FlipFitCustomerMenu customer =new FlipFitCustomerMenu();

            int choice =  index();;
            switch (choice) {
                case 1:

                    customer.login();
                    break;
                case 2:
                    customer.register();
                    break;
                case 3:
                    FlipFitApplicationMenu.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
        else if(role.equalsIgnoreCase("GymOwner")){
            FlipFitGymOwnerMenu gymOwner=new FlipFitGymOwnerMenu();
            int choice= index();

            System.out.println("Enter your email: ");
            String email = in.next();
            switch (choice) {
                case 1:
                    gymOwner.login();
//                    gymOwner.(in, email);
//                    gymOwner.gymOwnerPage(in, email);
                    break;
                case 2:
                    gymOwner.register();
                    break;
                case 3:
                    mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }
        }
        else {
            System.out.println("Please Enter valid role");
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