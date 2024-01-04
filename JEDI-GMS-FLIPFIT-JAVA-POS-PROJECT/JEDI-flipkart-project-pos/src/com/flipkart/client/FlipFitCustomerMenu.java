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
    FlipFitCustomerService flipFitCustomerService = new FlipFitCustomerService();
    public void login(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Customer Email Address: ");
        String customerEmail = in.nextLine();

        System.out.print("Enter Customer Password: ");
        String customerPassword = in.nextLine();
        if (flipFitCustomerService.isValidCustomerCredentials(customerEmail, customerPassword)) {
            System.out.println("Login successful!");
            customerMenu();
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
        customerMenu();
    }
    public void register(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Customer Address: ");
        String customerAddress = scanner.nextLine();

        System.out.print("Enter Customer Email Address: ");
        String customerEmailAddress = scanner.nextLine();

        System.out.print("Enter Customer Phone: ");
        int customerPhone = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter Customer Password: ");
        String password = scanner.nextLine();

        flipFitCustomerService.createCustomer(customerId,customerName,customerAddress,customerEmailAddress,customerPhone,password);
        customerMenu();
    }


    public static void customerMenu() {

        FlipFitCustomerService customerService = new FlipFitCustomerService();
        Customer customer = new Customer();
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("1. Search all Gyms");
        System.out.println("2. Search Gyms by location");

        System.out.println("3. View Booked slots");
        System.out.println("4. Cancel Booking");
        System.out.println("5. Make Payment");
        System.out.println("6. Edit Profile");
        System.out.println("7. View Profile");
        System.out.println("8. Exit");

        option = in.nextInt();


        if(option == 1) {
            customerService.searchAllGyms();
        }
        else if(option==2)
        {
            System.out.print("Enter the Location where you want to search");
            String location=in.next();
            customerService.searchGymOnLocation(location);
        }
        else if(option == 5) {
            System.out.println("Enter the customer Id you want to update");
            Integer customerId=in.nextInt();

            System.out.print("Enter new name: ");
            String newName = in.nextLine();
            customer.setCustomerName(newName);

            System.out.print("Enter new address: ");
            String newAddress = in.nextLine();
            customer.setCustomerAddress(newAddress);

            System.out.print("Enter new email address: ");
            String newEmail = in.nextLine();
            customer.setCustomerEmailAddress(newEmail);

            System.out.print("Enter new phone number: ");
            int newPhone = in.nextInt();
            customer.setCustomerPhone(newPhone);

            // Additional attributes can be added based on your Customer class

            in.nextLine(); // Consume the newline character left by nextInt()

            System.out.print("Enter new password: ");
            String newPassword = in.nextLine();

           customerService.editCustomer(customerId,newName,newAddress,newEmail,newPhone);
        }
else if (option==6)
        {
            System.out.println("enter the Customer Id you want to view");
            Integer customerId=in.nextInt();
            in.nextLine();
            customerService.viewCustomerProfile(customerId);
        }
        else if(option == 7) {
            FlipFitApplicationMenu gymApplication = new FlipFitApplicationMenu();
            try {
                gymApplication.main(null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        customerMenu();
    }
}