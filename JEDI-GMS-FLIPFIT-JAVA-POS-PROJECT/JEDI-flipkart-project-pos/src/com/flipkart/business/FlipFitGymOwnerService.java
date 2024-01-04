package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.FlipFitGymOwnerDao;

import java.util.List;

public class FlipFitGymOwnerService {
    FlipFitGymOwnerDao gymOwnerDao = new FlipFitGymOwnerDao();


    public void registerGymOwner(int ownerId,String ownerName,String ownerEmailAddress,int ownerPhone,int ownerGSTNum,boolean isApproved,String ownerAddress)
    {


    }
    public String getOwnerDetails(){
        return "get Owner Details";
    }

    public boolean viewAllSlots(int id) {
        System.out.println("view All Slots");
        return true;
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
        System.out.println("add slots");
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

}
