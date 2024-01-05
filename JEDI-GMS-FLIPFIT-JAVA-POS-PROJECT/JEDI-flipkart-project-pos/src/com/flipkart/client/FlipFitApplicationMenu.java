package com.flipkart.client;
import java.awt.Toolkit;
import com.flipkart.business.FlipFitAdminService;
import com.flipkart.business.FlipFitCustomerService;

import java.nio.Buffer;
import java.util.Scanner;

public class FlipFitApplicationMenu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private static String centerText(String text, int totalSpaces) {
        return String.format("%" + totalSpaces + "s%s%" + totalSpaces + "s", "", text, "");
    }
    public static void mainPage()  {


        boolean flag = true;
        while (flag) {
            int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;

            // Adjusted line length for full screen
            String line = "\033[1;35m" + "=".repeat(screenWidth) + "\033[0m";
            String welcomeMessage = "\u001B[1m\u001B[95mWelcome to FlipFit Application\u001B[0m";

            // Calculate the number of spaces needed for center alignment
            int totalSpaces = (200 - welcomeMessage.length()) / 2;

            // Create the centered line
            String centeredLine = line;

            // Create the centered message
            String centeredMessage = String.format("%" + totalSpaces + "s%s%" + totalSpaces + "s", "", welcomeMessage, "");

            // Print the centered line and message
            System.out.println(centeredLine);
            System.out.println(centeredMessage);
            System.out.println(centeredLine);

            Scanner in = new Scanner(System.in);
            System.out.println("Enter the EmailId: ");
            String email = in.next();
            System.out.println("Enter the Password: ");
            String password = in.next();

             totalSpaces = (190 - 30) / 2; // Assuming a console width of 80 characters

            // Print menu options with colors and center alignment

            System.out.println(centerText("\t" + ANSI_CYAN + "ENTER THE ROLE:" + ANSI_RESET, totalSpaces));
            System.out.println(centerText("\t" + ANSI_GREEN + "Press 1 For Admin" + ANSI_RESET, totalSpaces));
            System.out.println(centerText("\t" + ANSI_PURPLE + "Press 2 For Customer" + ANSI_RESET, totalSpaces));
            System.out.println(centerText("\t" + ANSI_RED + "Press 3 For Gym Owner" + ANSI_RESET, totalSpaces));
            System.out.println("Enter your role number:");
            int role = in.nextInt();

            if (role==1) {


                welcomeMessage = "\u001B[1m\u001B[95m Welcome to FlipFit Admin Menu\u001B[0m";

                // Calculate the number of spaces needed for center alignment
                totalSpaces = (200 - welcomeMessage.length()) / 2;

                // Create the centered line


                // Create the centered message
                centeredMessage = String.format("%" + totalSpaces + "s%s%" + totalSpaces + "s", "", welcomeMessage, "");
                System.out.println(centeredLine);
                System.out.println(centeredMessage);
                System.out.println(centeredLine);
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

                welcomeMessage = "\u001B[1m\u001B[95m Welcome to FlipFit Customer Menu\u001B[0m";

                // Calculate the number of spaces needed for center alignment
                totalSpaces = (200 - welcomeMessage.length()) / 2;

                // Create the centered line

                // Create the centered message
                centeredMessage = String.format("%" + totalSpaces + "s%s%" + totalSpaces + "s", "", welcomeMessage, "");
                System.out.println(centeredLine);
                System.out.println(centeredMessage);
                System.out.println(centeredLine);
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
                welcomeMessage = "\u001B[1m\u001B[95m Welcome to FlipFit GymOwner Menu\u001B[0m";

                // Calculate the number of spaces needed for center alignment
                totalSpaces = (200 - welcomeMessage.length()) / 2;

                // Create the centered line

                // Create the centered message
                centeredMessage = String.format("%" + totalSpaces + "s%s%" + totalSpaces + "s", "", welcomeMessage, "");
                System.out.println(centeredLine);
                System.out.println(centeredMessage);
                System.out.println(centeredLine);
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
        int totalSpaces = (190 - 13) / 2;

        // Print menu options with center alignment
        System.out.println(centerText(ANSI_CYAN + "1. Login" + ANSI_RESET, totalSpaces));
        System.out.println(centerText(ANSI_GREEN + "2. Register" + ANSI_RESET, totalSpaces));
        System.out.println(centerText(ANSI_RED + "3. Exit" + ANSI_RESET, totalSpaces));

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