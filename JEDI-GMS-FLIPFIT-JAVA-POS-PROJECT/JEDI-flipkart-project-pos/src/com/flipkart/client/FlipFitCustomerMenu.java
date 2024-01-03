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

import java.util.Scanner;

import com.flipkart.bean.Customer;
import com.flipkart.business.FlipFitCustomerService;

/**
 *
 */
public class FlipFitCustomerMenu {


    public static void customerMenu() {

        FlipFitCustomerService customerService = new FlipFitCustomerService();
        Customer customer = new Customer();
        Scanner in = new Scanner(System.in);
        int option;
        System.out.println(customerService.getCustomerDetails());

        System.out.println("1. Search Gym");
        System.out.println("2. View Booked slots");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Make Payment");
        System.out.println("5. Edit Profile");
        System.out.println("6. Exit");

        option = in.nextInt();

        if(option == 1) {
            customerService.searchGym("Location1");
        }
        else if(option == 5) {
            System.out.println("1. Edit name");
            System.out.println("2. Edit email address");
            System.out.println("3. Edit phone");

            int subOption = in.nextInt();

            if(subOption == 1) {
                String name = in.next();
                customer.setCustomerName(name);
                System.out.println("Name changed successfully");
            }

            if(subOption == 2) {
                String email = in.next();
                customer.setCustomerEmailAddress(email);
                System.out.println("Email changed successfully");
            }

            if(subOption == 3) {
                int phone = in.nextInt();
                customer.setCustomerPhone(phone);
                System.out.println("Contact number changed successfully");
            }

        }

        else if(option == 6) {
            FlipFitApplicationMenu gymApplication = new FlipFitApplicationMenu();
            try {
                gymApplication.main(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}