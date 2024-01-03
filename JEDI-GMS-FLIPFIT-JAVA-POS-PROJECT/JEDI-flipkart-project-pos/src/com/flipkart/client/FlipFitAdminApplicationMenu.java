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

    public void viewPendingGymCentres() {
        // TODO Auto-generated method stub
        List<GymCenter> gymDetails = flipFitAdminService.viewPendingGymRequests();
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-16s %-13s %-16s %-16s %n", "Gym Id","Name", "Address", "Approved");
        System.out.println("--------------------------------------------------------");
        for(GymCenter gym: gymDetails) {
            System.out.printf("%-16s", gym.getId());
            System.out.printf("%-16s", gym.getGymName());
            System.out.printf("%-16s", gym.getGymLocation());
            if(gym.isApproved()){
                System.out.printf("%-16s", "Yes");
            }
            else
            {
                System.out.printf("%-16s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }

    public void viewPendingGymOwners() {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        Integer id = in.nextInt();
        List<GymOwner> gymOwnerDetails = flipFitAdminService.viewPendingGymOwnerRequests(id);

        System.out.printf("%-19s %-13s %-24s %-17s %-15s %n", "Email", "Name", "Aadhaar Number", "GST Number", "Approved");
        for(GymOwner owner: gymOwnerDetails) {
            System.out.printf("%-16s\t", owner.getOwnerEmailAddress());
            System.out.printf("%-16s\t", owner.getOwnerName());
            System.out.printf("%-16s\t", owner.getOwnerAddress());
            System.out.printf("%-16s\t", owner.getOwnerGSTNum());
            if(owner.isApproved())
            {
                System.out.printf("%-16s\t", "Yes");
            }
            else
            {
                System.out.printf("%-16s\t", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGyms() {
        // TODO Auto-generated method stub
        List<GymCenter> gymDetails = flipFitAdminService.viewAllApprovedGyms();

        System.out.printf("%-16s %-13s %-11s %16s %n", "Gym Id", "Name", "Address", "Approved");
        for(GymCenter gym: gymDetails) {
            System.out.printf("%-16s", gym.getId());
            System.out.printf("%-16s", gym.getGymName());
            System.out.printf("%-20s", gym.getGymLocation());
            if(gym.isApproved())
            {
                System.out.printf("%-20s", "Yes");
            }
            else
            {
                System.out.printf("%-20s", "No");
            }
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void viewAllGymOwners() {

        List<GymOwner> gymOwnerDetails = flipFitAdminService.viewAllApprovedGymOwners();
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-15s %-13s %-16s %-12s %12s %n", "Email", "Name", "Address", "GST Number", "Approved");
        System.out.println("------------------------------------------------------------------");
        for(GymOwner owner: gymOwnerDetails) {

            System.out.printf("%-16s", owner.getOwnerEmailAddress());
            System.out.printf("%-16s", owner.getOwnerName());
            System.out.printf("%-16s", owner.getOwnerAddress());
            System.out.printf("%-18s", owner.getOwnerGSTNum());
            if(owner.isApproved())
            {
                System.out.printf("%-18s", "Yes");
            }
            else
            {
                System.out.printf("%-18s", "No");
            }
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------------");
        System.out.println();
    }

    public void AdminPage(Scanner in) throws Exception {
        while(true) {
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
                    viewAllGymOwners();
                    break;
                case 2:
                    viewPendingGymOwners();
                    break;
                case 3:
                    viewAllGyms();
                    break;
                case 4:
                    viewPendingGymCentres();
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

    public static void AdminMenu() {
        FlipFitAdminService adminService = new FlipFitAdminService();
        Admin admin = new Admin();
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("1. Approve Gym Owner Registration");
        System.out.println("2. View List of Registered Gyms by id");
        System.out.println("3. View List of Registered Gyms by name");
        System.out.println("4. View List of Pending Gyms by id");
        System.out.println("5. View List of Pending Gyms by name");
        System.out.println("6. View List of Registered Customers");
        System.out.println("7. Edit Admin Profile");
        System.out.println("8. Exit");
        option = in.nextInt();

        if(option == 7) {
            System.out.println("1. Edit name");
            System.out.println("2. Edit email address");
            System.out.println("3. Edit phone");

            int subOption = in.nextInt();

            if(subOption == 1) {
                String name = in.next();
                admin.setAdminName(name);
                System.out.println("Name changed successfully");
            }

            if(subOption == 2) {
                String email = in.next();
                admin.setAdminEmailAddress(email);
                System.out.println("Email changed successfully");
            }

            if(subOption == 3) {
                int phone = in.nextInt();
                admin.setAdminPhone(phone);
                System.out.println("Contact number changed successfully");
            }

        }

        if(option == 8) {
            FlipFitGymOwnerMenu gymApplication = new FlipFitGymOwnerMenu();
            gymApplication.main(null);
        }
    }


}