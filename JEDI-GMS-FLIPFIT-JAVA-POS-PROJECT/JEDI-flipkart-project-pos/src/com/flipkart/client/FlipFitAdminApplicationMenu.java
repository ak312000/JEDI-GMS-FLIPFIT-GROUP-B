//package com.flipkart.client;
//
//import com.flipkart.business.FlipFitAdminService;
//import com.flipkart.business.FlipFitGymOwnerService;
//
//import java.util.Scanner;
//
//public class FlipFitAdminApplicationMenu {
//
//    public void adminApplicationMenu() {
//        boolean opt = true;
//        while (opt) {
//            System.out.println("Welcome to the Admin Menu");
//
//            System.out.println("\t\t\t1.) View Customers");
//            System.out.println("\t\t\t2.) Approve Customers");
//            System.out.println("\t\t\t3.) Register Details");
//
//
//            System.out.println("\t\t\t4.) Manage GymCentre");
//            System.out.println("\t\t\t5.) Exit");
//            System.out.println("Enter the choice you want to perform:");
//
//
//            Scanner in = new Scanner(System.in);
//            int choice = in.nextInt();
//            switch (choice) {
//                case 1:
//                    System.out.println("You are in customer management");
//                    break;
//                case 2:
//                    System.out.println("You are now approved in gym centre management");
//                    break;
//                case 3:
//                    System.out.println("Register Details");
//                    break;
//                case 4:
//                    System.out.println("gym center managing functions being called here");
//                    break;
//                default:
//                    opt = false;
//                    break;
//            }
//        }
//    }
//}
//package com.flipkart.client;
//
//import java.util.Scanner;
//
//import com.flipkart.bean.Customer;
//import com.flipkart.business.FlipFitAdminService;
//import com.flipkart.business.FlipFitCustomerService;
//import com.flipkart.business.FlipFitUserService;
//
///**
// *
// */
//public class FlipFitAdminApplicationMenu {
//
//    /**
//     * @param args
//     */
//    public static void mainPage() {
//        System.out.println("Welcome to FlipFit Application");
//
//        Scanner in = new Scanner(System.in);
//        System.out.println("Enter the role");
//        String role = in.next();
//
//        if(role.equalsIgnoreCase("Admin")){
//            System.out.println("Welcome to Admin Menu");
//            AdminGMSMenu admin=new AdminGMSMenu();
//            admin.AdminPage(in);
//        }
//        else if(role.equalsIgnoreCase("Customer")){
//            System.out.println("Welcome to Customer Menu");
//            CustomerGMSMenu customer=new CustomerGMSMenu();
//            //while(true){
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//            int choice = in.nextInt();
//            switch (choice) {
//                case 1:
//                    customer.CustomerRegistration(in);
//                    break;
//                case 2:
//                    login();
//                    break;
//                case 3:
//                    GymApplicationClient.mainPage();
//                    break;
//                default:
//                    System.out.println("Incorrect choice");
//            }
//        }
//        else if(role.equalsIgnoreCase("GymOwner")){
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: " );
//            int choice = sc.nextInt();
//            GymGMSMenu gymOwner=new GymGMSMenu();
//            System.out.println("Enter your email: ");
//            String email = in.next();
//            switch (choice) {
//                case 1:
//                    gymOwner.registerGymOwner(in, email);
//                    gymOwner.gymOwnerPage(in, email);
//                    break;
//                case 2:
//                    gymOwner.gymOwnerPage(in, email);
//                    break;
//                case 3:
//                    GymApplicationClient.mainPage();
//                    break;
//                default:
//                    System.out.println("Incorrect choice");
//            }
//        }
//
//
//    }
//
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        FlipFitCustomerService customerService = new FlipFitCustomerService();
//        FlipFitAdminService adminService = new FlipFitAdminService();
//
//
//
//    }
//
//}
package com.flipkart.client;

import java.util.List;
import java.util.Scanner;


import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.dao.FlipFitAdminDao;

/**
 *
 */
public class FlipFitAdminApplicationMenu {
    FlipFitAdminService flipFitAdminService = new FlipFitAdminService();

//    public void approveGymCentre(Scanner in) {
//        // TODO Auto-generated method stub
//        System.out.println("Enter the gym Id: ");
//        int gymId = in.nextInt();
//        FlipFitAdminInterface flipFitAdminInterface = new FlipFitAdminService();
//        flipFitAdminInterface.(gymId);
//
//    }

    public void approveGymOwner(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println("Enter the owner email: ");
        Integer id = in.nextInt();
        flipFitAdminService.approveGymOwnerRegistration(id);

    }








    public void Login() {
        Scanner in = new Scanner(System.in);

        // Get admin email and password from the user
        System.out.print("Enter Admin Email Address: ");
        String adminEmail = in.nextLine();

        System.out.print("Enter Admin Password: ");
        String adminPassword = in.nextLine();

        if (flipFitAdminService.isValidAdminCredentials(adminEmail, adminPassword)) {
            System.out.println("Login successful!");
            AdminPage();
        } else {
            System.out.println("Invalid credentials. Login failed.");
        }
    }



    public void register() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admin ID: ");
        int adminId = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character left by nextInt()

        System.out.print("Enter Admin Name: ");
        String adminName = scanner.nextLine();

        System.out.print("Enter Admin Email Address: ");
        String adminEmailAddress = scanner.nextLine();

        System.out.print("Enter Admin Phone: ");
        String phone = scanner.nextLine();



        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();
        flipFitAdminService.createAdmin(adminId,adminName,adminEmailAddress,phone,password);
        AdminPage();
    }


    public void AdminPage() {
        while(true) {
            Scanner in = new Scanner(System.in);
            System.out.println("1. View All Gym Owners");
            System.out.println("2. View All Pending Gym Owners");
            System.out.println("3. View All Gym Centres");
            System.out.println("4. View All Pending Gym Centres");
            System.out.println("5. Approve Gym Owner");
            System.out.println("6. Approve Gym Centre");
            System.out.println("7. Exit");
            System.out.print("Enter number: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    flipFitAdminService.viewAllGymOwners();
                    break;
                case 2:
                    flipFitAdminService.viewAllPendingGymOwners();
                    break;
                case 3:
                    flipFitAdminService.viewAllGyms();
                    break;
                case 4:
                    flipFitAdminService.viewPendingGymCentres();
                    break;
                case 5:
                    approveGymOwner(in);
                    break;
                case 6:
//                    approveGymCentre(in);
                    break;
                case 7:
                    FlipFitApplicationMenu.mainPage();
                    break;
                default:
                    System.out.println("Invalid number");
            }
        }

    }


}