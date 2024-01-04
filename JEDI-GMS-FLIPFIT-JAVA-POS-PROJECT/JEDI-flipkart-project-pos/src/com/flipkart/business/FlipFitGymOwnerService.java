package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.TimeSlot;
import com.flipkart.dao.FlipFitGymCentreDao;
import com.flipkart.dao.FlipFitGymOwnerDao;
import com.flipkart.dao.FlipFitSlotDao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipFitGymOwnerService {
    FlipFitGymOwnerDao gymOwnerDao = new FlipFitGymOwnerDao();
    FlipFitGymCentreDao gymcenterDao = new FlipFitGymCentreDao();

    FlipFitSlotDao slotDao= new FlipFitSlotDao();
//    GymCenter gym = new GymCenter();

    public void registerGymOwner(int ownerId,String ownerName,String ownerEmailAddress,int ownerPhone,int ownerGSTNum,boolean isApproved,String ownerAddress)
    {


    }
    public String getOwnerDetails(){
        return "get Owner Details";
    }

    public void viewAllSlots() {

        System.out.println("View All Slots");
        List<TimeSlot> slots=slotDao.viewAllSlots();
        for(TimeSlot slot:slots){
            System.out.println(slot);
        }
    }

    public boolean isApprovedGymOwner(int id) {
        System.out.println("is Approved Gym Owner");
        return true;
    }

    public boolean isApprovedGymCenter() {
        System.out.println("is Approved Gym Center");
        return true;
    }

    public void addSlots() {
        TimeSlot timeSlot = new TimeSlot();

        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Taking input for each property
        System.out.print("Enter Gym ID: ");
        timeSlot.setGymId(scanner.nextInt());

        System.out.print("Enter Slot ID: ");
        timeSlot.setSlotId(scanner.nextInt());

        System.out.print("Enter Date: ");
        timeSlot.setDate(scanner.nextInt());

        timeSlot.setCustomerId(new ArrayList<>());

        System.out.print("Enter Time: ");
        timeSlot.setTime(scanner.nextLine());
        slotDao.add(timeSlot);
        // Closing the Scanner to avoid resource leak
        scanner.close();
    }

    public boolean addGym(int id) {
        System.out.println("add gym");
        return true;
    }

    public boolean createSlot(int id) {
        System.out.println("create slot");
        return true;
    }

    public void viewAllGymCenters() {
        System.out.println("view All Gym Centers");
    }

    public void viewAllApprovedGymCenters() {
        System.out.println("view All Approved Gym Centers");
        List<GymCenter> ApprovedGymCentres=gymcenterDao.viewApprovedGymCentres();
        for(GymCenter gymCenter:ApprovedGymCentres){
            System.out.println(gymCenter);
        }
    }

    public void createGymOwner(int ownerId, String ownerName, String ownerEmailAddress, int ownerPhone, int ownerGSTNum, boolean isApproved, String ownerAddress,String password) {
        System.out.println("reached here");
        GymOwner gymOwner = new GymOwner();
        // Set the properties of the GymOwner object
        gymOwner.setPassword(password);
        gymOwner.setOwnerId(ownerId);
        gymOwner.setOwnerName(ownerName);
        gymOwner.setOwnerEmailAddress(ownerEmailAddress);
        gymOwner.setOwnerPhone(ownerPhone);
        gymOwner.setOwnerGSTNum(ownerGSTNum);
        gymOwner.setApproved(isApproved);
        gymOwner.setOwnerAddress(ownerAddress);
        System.out.println("setting complete");
        System.out.println(gymOwner.getOwnerId());

        gymOwnerDao.add(gymOwner);
        System.out.println("line 74 reached");
        // Return the created GymOwner object

    }

    public boolean isValidGymOwnerCredentials( String email, String password) {
        List<GymOwner> allGymOwners = gymOwnerDao.getAllGymOwners();
        // Check if the entered credentials match any of the admins in the list
        for (GymOwner gymOwner : allGymOwners) {
            if (gymOwner.getOwnerEmailAddress().equals(email) && gymOwner.getPassword().equals(password)) {
                return true; // Credentials are valid
            }
        }
        return false; // No matching admin found
    }

    public void registerGymCenter() {
        GymCenter gym = new GymCenter();
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Gym ID: ");
        gym.setId(scanner.nextInt());

        System.out.print("Enter Gym Name: ");
        gym.setGymName(scanner.next());

        System.out.print("Enter Gym Email Address: ");
        gym.setGymEmailAddress(scanner.next());

        System.out.print("Enter Gym Location: ");
        gym.setGymLocation(scanner.next());

        System.out.print("Enter Number of Seats in a Slot: ");
        gym.setNumOfSeats(scanner.nextInt());

        scanner.close();
        gymcenterDao.add(gym);
        System.out.println("Registered Successfully!");

    }

    public void editGym() {
        System.out.println("Edit the gym details:");
        GymCenter gym = new GymCenter();
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        boolean flag=false;
        // Taking input for each property
        System.out.print("Enter Gym ID: ");
        int id=scanner.nextInt();
        List<GymCenter> allGymCenter = gymcenterDao.getGymCenters();
        for (GymCenter gymCenter :allGymCenter) {
            if (gymCenter.getId()==id) {
                System.out.print("Enter Gym Name: ");
                gymCenter.setGymName(scanner.nextLine());
                System.out.print("Enter Gym Email Address: ");
                gymCenter.setGymEmailAddress(scanner.nextLine());

                System.out.print("Enter Gym Location: ");
                gymCenter.setGymLocation(scanner.nextLine());

                System.out.print("Enter Number of Seats in a Slot: ");
                gymCenter.setNumOfSeats(scanner.nextInt());
                System.out.println("Details updated !");
                flag=true;
            }

        }
        if(!flag)
            System.out.println("Please enter the correct id");


    }

    public void editSlots() {
        System.out.println("Edit the slot details:");
        TimeSlot slot = new TimeSlot();
        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        boolean flag=false;
        // Taking input for each property
        System.out.print("Enter Slot ID: ");
        int id=scanner.nextInt();
        List<TimeSlot> allSlots = slotDao.viewAllSlots();
        for (TimeSlot sl :allSlots) {
            if (sl.getSlotId()==id) {
                System.out.print("Enter New Date: ");
                sl.setDate(scanner.nextInt());
                System.out.print("Enter New Time: ");
                sl.setTime(scanner.nextLine());
                System.out.println("slots updated!");
                flag = true;
            }
        }
        if(!flag)
            System.out.println("Please enter the correct id");

    }

    public void editProfile() {
        System.out.println("Edit Profile:");
        GymOwner gymOwner = new GymOwner();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Owner ID: ");
        int ownerId = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character left by nextInt()
        List<GymOwner> allGymOwners = gymOwnerDao.getAllGymOwners();
        boolean flag=false;
        for (GymOwner gymowner :allGymOwners) {
            if(gymowner.getOwnerId()==ownerId) {
                System.out.print("Enter Owner Name: ");
                gymowner.setOwnerName( scanner.nextLine());

                System.out.print("Enter Owner Email Address: ");
                gymowner.setOwnerAddress( scanner.nextLine());


                System.out.print("Enter Owner Phone: ");
                gymowner.setOwnerPhone(scanner.nextInt());

                scanner.nextLine(); // Consume the newline character left by nextInt()

                System.out.print("Enter Owner GST Number: ");
                gymowner.setOwnerGSTNum( scanner.nextInt());

                System.out.print("Is Owner Approved? (true/false): ");
                gymowner.isApproved();

                scanner.nextLine(); // Consume the newline character left by nextBoolean()


                System.out.print("Enter Gym Owner Password: ");
                gymowner.setPassword( scanner.nextLine());
                flag=true;
                System.out.println("Details Updated");
            }
        }
        if(!flag)
            System.out.println("Please enter correct id");

    }
}
