package com.flipkart.client;

import java.nio.Buffer;
import java.util.Scanner;

public class FlipFitApplicationMenu {
    public static void main(String args[]){
        boolean Flag=true;
        while(Flag){
            System.out.println("Welcome to the FlipFitApp");
            System.out.println("Enter the choice:");
            System.out.println("\t1.) Login");
            System.out.println("\t2.) Registration of the Customer (SignUp)");
            System.out.println("\t3.)  Update Password");
            System.out.println("\t4.) Exit");

            Scanner in = new Scanner(System.in);
            int operation=in.nextInt();
            in.nextLine();
            switch (operation){
                case 1:
                    System.out.print("\tEnter your Username: ");
                    String Username = in.nextLine();
//                    System.out.println(Username);
                    System.out.print("\tEnter your Password: ");
                    String Password = in.nextLine();

                    int role;
                    System.out.println("\tEnter the Role:");
                    System.out.println("\t\t1.) Customer");
                    System.out.println("\t\t2.) Gym Owner");
                    System.out.println("\t\t3.)  Admin");
                    role=in.nextInt();
                    switch (role){
                        case 1 :
                            FlipFitCustomerMenu flipFitCustomerMenu = new FlipFitCustomerMenu();
                            flipFitCustomerMenu.customerApplicationMenu();
                            break;
                        case 2:
                            FlipFitGymOwnerMenu flipFitGymOwnerMenu = new FlipFitGymOwnerMenu();
                            flipFitGymOwnerMenu.gymOwnerApplicationMenu();
                            break;
                        case 3:
                            FlipFitAdminApplicationMenu flipFitAdminApplicationMenu = new FlipFitAdminApplicationMenu();
                            flipFitAdminApplicationMenu.adminApplicationMenu();
                            break;
                        default:
                            break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\tEnter your Username: ");
                    String NewUsername = in.nextLine();
                    System.out.print("\tCreate your Password: ");
                    String NewPassword = in.nextLine();
                    System.out.println("\tEnter the Role:");
                    System.out.println("\t\t1.) Customer");
                    System.out.println("\t\t2.) Gym Owner");
                    System.out.println("\t\t3.)  Admin");
                    int NewRole = in.nextInt();
                    System.out.println("\tEnter your Email: ");
                    String Email = in.nextLine();
                    System.out.print("\tEnter your Location: ");
                    String Location = in.nextLine();
                    System.out.println("\tYou have successfully registered to FlipFit");
                    break;
                case 3 :
                    System.out.print("\tEnter your Username: ");
                    String UsernameUpdate = in.nextLine();
                    System.out.print("\tPlease Update Your Password} ");
                    String newPassword = in.nextLine();
                    System.out.println("\tYou have successfully Changed Your FlipFit Password");
                    break;
                case 4:
                    Flag=false;
                    break;
            }

        }
    }
}
