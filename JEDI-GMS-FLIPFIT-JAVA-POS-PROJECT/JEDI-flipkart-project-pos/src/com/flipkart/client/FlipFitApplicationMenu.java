package com.flipkart.client;

import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitCustomerService;

import java.nio.Buffer;
import java.util.Scanner;

//public class FlipFitApplicationMenu {
//    public static void main(String args[]){
//        boolean Flag=true;
//        while(Flag){
//            System.out.println("Welcome to the FlipFitApp");
//            System.out.println("Enter the choice:");
//            System.out.println("\t1.) Login");
//            System.out.println("\t2.) Registration of the Customer (SignUp)");
//            System.out.println("\t3.)  Update Password");
//            System.out.println("\t4.) Exit");
//
//            Scanner in = new Scanner(System.in);
//            int operation=in.nextInt();
//            in.nextLine();
//            switch (operation){
//                case 1:
//                    System.out.print("\tEnter your Username: ");
//                    String Username = in.nextLine();
////                    System.out.println(Username);
//                    System.out.print("\tEnter your Password: ");
//                    String Password = in.nextLine();
//
//                    int role;
//                    System.out.println("\tEnter the Role:");
//                    System.out.println("\t\t1.) Customer");
//                    System.out.println("\t\t2.) Gym Owner");
//                    System.out.println("\t\t3.)  Admin");
//                    role=in.nextInt();
//                    switch (role){
//                        case 1 :
//                            FlipFitCustomerMenu flipFitCustomerMenu = new FlipFitCustomerMenu();
//                            flipFitCustomerMenu.customerApplicationMenu();
//                            break;
//                        case 2:
//                            FlipFitGymOwnerMenu flipFitGymOwnerMenu = new FlipFitGymOwnerMenu();
//                            flipFitGymOwnerMenu.gymOwnerApplicationMenu();
//                            break;
//                        case 3:
//                            FlipFitAdminApplicationMenu flipFitAdminApplicationMenu = new FlipFitAdminApplicationMenu();
//                            flipFitAdminApplicationMenu.adminApplicationMenu();
//                            break;
//                        default:
//                            break;
//                    }
//                    System.out.println();
//                    System.out.println();
//                    System.out.println();
//                    break;
//                case 2:
//                    System.out.print("\tEnter your Username: ");
//                    String NewUsername = in.nextLine();
//                    System.out.print("\tCreate your Password: ");
//                    String NewPassword = in.nextLine();
//                    System.out.println("\tEnter the Role:");
//                    System.out.println("\t\t1.) Customer");
//                    System.out.println("\t\t2.) Gym Owner");
//                    System.out.println("\t\t3.)  Admin");
//                    int NewRole = in.nextInt();
//                    in.nextLine();
//                    System.out.println("\tEnter your Email: ");
//                    String Email = in.nextLine();
//                    System.out.print("\tEnter your Location: ");
//                    String Location = in.nextLine();
//                    System.out.println("\tYou have successfully registered to FlipFit");
//                    break;
//                case 3 :
//                    System.out.print("\tEnter your Username: ");
//                    String UsernameUpdate = in.nextLine();
//                    System.out.print("\tPlease Update Your Password} ");
//                    String newPassword = in.nextLine();
//                    System.out.println("\tYou have successfully Changed Your FlipFit Password");
//                    break;
//                case 4:
//                    Flag=false;
//                    break;
//            }
//
//        }
//    }



//}
//
public class FlipFitApplicationMenu {
    public static void mainPage() throws Exception {
        System.out.println("Welcome to FlipFit Application");

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the role");
        String role = in.next();

        if(role.equalsIgnoreCase("Admin")){
            System.out.println("Welcome to Admin Menu");
            FlipFitAdminApplicationMenu admin=new FlipFitAdminApplicationMenu();
            admin.AdminPage(in);
        }
        else if(role.equalsIgnoreCase("Customer")){
            System.out.println("Welcome to Customer Menu");
            FlipFitCustomerMenu flipFitCustomerMenu =new FlipFitCustomerMenu();
            //while(true){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    customer.CustomerRegistration(in);
                    break;
                case 2:
                    flipFitCustomerMenu.customerMenu();
                    break;
                case 3:
                    FlipFitApplicationMenu.mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }
        else if(role.equalsIgnoreCase("GymOwner")){
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: " );
            int choice = in.nextInt();
            FlipFitGymOwnerMenu gymOwner=new FlipFitGymOwnerMenu();
            System.out.println("Enter your email: ");
            String email = in.next();
            switch (choice) {
                case 1:
                    gymOwner.registerGymOwner(in, email);
                    gymOwner.gymOwnerPage(in, email);
                    break;
                case 2:
                    gymOwner.gymOwnerMenu();
                    break;
                case 3:
                    mainPage();
                    break;
                default:
                    System.out.println("Incorrect choice");
            }
        }

		/*System.out.println("Welcome to flip fit application\n");
		System.out.println("Menu for operation:");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Update Password");
		System.out.println("4. Exit");
		int op = in.nextInt();


		switch(op) {
			case 1: int op1;
				System.out.println("Enter username");
				String username = in.next();

				System.out.println("Enter password");
				String password = in.next();

				System.out.println("Enter role");
				String role = in.next();

				if(role.equalsIgnoreCase("Admin")) {
					AdminClient admin = new AdminClient();
					admin.AdminMenu();

				}
				else if (role.equalsIgnoreCase("GymOwner")) {
					GymOwnerClient gymOwner = new GymOwnerClient();
					gymOwner.main(args);
				}
				else if (role.equalsIgnoreCase("Customer")){
					CustomerClient.customerMenu();
				}
				else {
					System.out.println("Invalid role");
				}
				break;

			case 2:
				System.out.println("Enter role");
				String roleChoosed = in.next();

				System.out.println("Enter id");
				int id = in.nextInt();

				System.out.println("Enter name");
				String name = in.next();

				System.out.println("Enter email");
				String email = in.next();

				System.out.println("Enter phone");
				int phone = in.nextInt();

				System.out.println("Enter password");
				String password1 = in.next();

				if(roleChoosed.equals("customer")) {
					customerService.createCustomer(id, name, email, phone, password1);
				}

				if(roleChoosed.equals("admin")) {
					adminService.createAdmin(id, name, email, phone, password1);
				}
		}*/
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        FlipFitApplicationMenu.mainPage();
    }

}