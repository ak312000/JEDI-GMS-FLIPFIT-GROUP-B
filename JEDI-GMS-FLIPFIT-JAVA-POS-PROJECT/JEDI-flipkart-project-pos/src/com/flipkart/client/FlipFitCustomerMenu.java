//package com.flipkart.client;
//
//import com.flipkart.business.FlipFitCustomerService;
//
//import java.util.Scanner;
//
//public class FlipFitCustomerMenu {
//
//    public void customerApplicationMenu() {
//
//
//        boolean opt = true;
//        while (opt) {
//            System.out.println("Welcome to the Customer Menu");
//            System.out.println("\t\t\t1.) View Profile");
//            System.out.println("\t\t\t2.) View Gyms");
//
//            System.out.println("\t\t\t3.) Book a slot");
//            System.out.println("\t\t\t4.) cancel a slot");
//            System.out.println("\t\t\t5.) Exit");
//            System.out.println("Enter the choice you want to perform:");
//            Scanner in = new Scanner(System.in);
//            int choice = in.nextInt();
//            in.nextLine();
//            switch (choice) {
//                case 1:
//                    System.out.println("This is your profile");
//                    break;
//                case 2:
//                    System.out.println("View Gyms");
//                    break;
//                case 3:
//                    System.out.println("Book Slots");
//                    break;
//                case 4:
//                    System.out.println("Cancel a slot");
//                    break;
//                default:
//                    opt = false;
//                    break;
//            }
//        }
//
//    }


//                FlipFitCustomerService customerService=new FlipFitCustomerService();
//        customerService.createCustomer();
//        System.out.println(customerService.updateCustomer(101));
//        System.out.println(customerService.deleteCustomer(101));
//        customerService.listCustomer();}


//}

package com.flipkart.client;

import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.business.FlipFitCustomerService;

/**
 *
 */
public class FlipFitCustomerMenu {
    FlipFitCustomerService customerService = new FlipFitCustomerService();
    public void login(String email,String password){
        if (customerService.isValidCustomerCredentials(email, password)) {
            System.out.println("Login successful!");
            customerMenu();
        } else {
            System.out.println("Invalid credentials. Login failed. Please Try again.....");
        }
        customerMenu();
    }
    public void register(String email, String password){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter Customer Phone: ");
        String customerPhone = scanner.nextLine();

        scanner.nextLine();
        customerService.createCustomer(customerName,customerAddress,email,customerPhone,password);
        customerMenu();
    }


    public void customerMenu() {


        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("\u001B[96mCustomer Menu:\u001B[0m");
        System.out.println("\u001B[92m1. Search all Gyms\u001B[0m");
        System.out.println("\u001B[92m2. Search Gyms by location\u001B[0m");
        System.out.println("\u001B[92m3. View Booked Slots\u001B[0m");
        System.out.println("\u001B[92m4. Cancel Booking\u001B[0m");
        System.out.println("\u001B[92m5. Make Payment\u001B[0m");
        System.out.println("\u001B[92m6. Edit Profile\u001B[0m");
        System.out.println("\u001B[92m7. View Profile\u001B[0m");
        System.out.println("\u001B[95m8. Exit\u001B[0m");


        option = in.nextInt();

        switch (option){
            case 1:
                customerService.searchAllGyms();
                break;
            case 2:
                System.out.print("Enter the Location where you want to search");
                String location=in.next();
                customerService.searchGymOnLocation(location);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                customerService.editCustomer();
                break;
            case 7:
                System.out.println("enter the Customer Id you want to view");
                String email=in.nextLine();
                customerService.viewCustomerProfile(email);
            case 8:
                FlipFitApplicationMenu gymApplication = new FlipFitApplicationMenu();
                try {
                    gymApplication.main(null);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                customerMenu();
        }
    }
}