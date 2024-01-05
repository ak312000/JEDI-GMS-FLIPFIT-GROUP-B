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
        Scanner in=new Scanner(System.in);
        System.out.println("Enter GymId whose slot need to check:");
        int gymId=  in.nextInt();
        in.nextLine();
        List<TimeSlot> slots=slotDao.viewAllSlots(gymId);
        System.out.println();
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-15s %-13s %-16s %-12s %12s %n", "SlotId", "GymId", "Day", "startTime", "EndTime");
        System.out.println("------------------------------------------------------------------");
        for(TimeSlot slot: slots) {

            System.out.printf("%-16s", slot.getSlotId());
            System.out.printf("%-16s", slot.getGymId());
            System.out.printf("%-16s", slot.getDay());
            System.out.printf("%-18s", slot.getStartTime());
            System.out.printf("%-18s", slot.getStartTime());
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------------------");
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Gym id: ");
        int gymId= scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Day of Booking: ");
        String day= scanner.nextLine();
        System.out.print("Enter Start Time: ");
        String startTime= scanner.nextLine();
        System.out.print("Enter End Time: ");
        String endTime= scanner.nextLine();
        TimeSlot timeSlot = new TimeSlot(gymId,day,startTime,endTime);
        slotDao.add(timeSlot);
    }





    public void viewAllGymCenters() {
        System.out.println("view All Gym Centers");
    }

    public void viewAllApprovedGymCenters() {
        System.out.println("Viewing All Gym Centers");
        List<GymCenter> ApprovedGymCentres=gymcenterDao.viewApprovedGymCentres();

    }

    public void createGymOwner(String email, String password) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Owner Name: ");
        String ownerName = scanner.nextLine();

        System.out.print("Enter Owner Phone: ");
        String ownerPhone = scanner.nextLine();

        System.out.print("Enter Owner GST Number: ");
        int ownerGSTNum = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextBoolean()

        System.out.print("Enter Owner Address: ");
        String ownerAddress = scanner.nextLine();

        GymOwner gymOwner = new GymOwner(ownerName,ownerPhone,ownerGSTNum,ownerAddress,email,password,true);
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

        // Creating a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Gym Name: ");
        String gymName= scanner.nextLine();

        System.out.print("Enter Gym Email Address: ");
        String gymEmail=scanner.nextLine();

        System.out.print("Enter Gym Location: ");
        String gymLocation=scanner.nextLine();

        System.out.print("Enter Number of Seats in a Slot: ");
        int gymNoOfSlots=scanner.nextInt();
        GymCenter gym = new GymCenter(gymName,gymEmail,gymLocation,gymNoOfSlots);


        gymcenterDao.add(gym);
        System.out.println("Gym Centre Registered Successfully!");

    }

    public void editGym() {
        System.out.println("Edit the gym Centre details:");
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
        Scanner scanner = new Scanner(System.in);
        boolean flag=false;
        System.out.print("Enter Gym ID: ");
        int gymId=scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Slot ID: ");
        int slotId=scanner.nextInt();
        scanner.nextLine();
        List<TimeSlot> allSlots = slotDao.viewAllSlots(gymId);
        for (TimeSlot sl :allSlots) {
            if (sl.getSlotId()==slotId) {
                System.out.print("Enter New Day: ");
                sl.setDay(scanner.nextLine());
                System.out.print("Enter New Start Time for this slot: ");
                sl.setStartTime(scanner.nextLine());
                System.out.print("Enter New End Time for this slot: ");
                sl.setEndTime(scanner.nextLine());
                System.out.println("slot updated!");
                flag = true;
            }
        }
        if(!flag)
            System.out.println("Please enter the correct id");

    }

    public void editProfile() {
        System.out.println("Editing Profile:");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Email ID: ");
        String ownerEmailId = scanner.nextLine();
        List<GymOwner> allGymOwners = gymOwnerDao.getAllGymOwners();
        boolean flag=false;
        for (GymOwner gymowner :allGymOwners) {
            if(gymowner.getOwnerEmailAddress().equals(ownerEmailId)) {
                System.out.print("Enter New Owner Name ");
                gymowner.setOwnerName(scanner.nextLine());
                System.out.print("Enter New Phone number ");
                gymowner.setOwnerPhone(scanner.nextLine());
                System.out.print("Enter New GST Number ");
                gymowner.setOwnerGSTNum(scanner.nextInt());
                System.out.print("Enter New Adress ");
                gymowner.setOwnerAddress(scanner.nextLine());
                System.out.println("Gym Owner Details updated!");
                flag=true;
            }
        }
        if(!flag)
            System.out.println("Please enter correct email");

    }
}
