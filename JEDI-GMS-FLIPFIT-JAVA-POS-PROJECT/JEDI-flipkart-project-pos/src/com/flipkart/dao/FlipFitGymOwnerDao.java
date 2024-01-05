package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDao {

    public FlipFitGymOwnerDao() {
        initializeDummyGymOwners();
    }

    private void initializeDummyGymOwners() {
        add(new GymOwner("John Doe", "1234567890", 123456, "Location A", "john@example.com", "password123",true));
        add(new GymOwner("Jane Doe", "9876543210", 654321, "Location B", "jane@example.com", "pass456",false));
        add(new GymOwner("Alice Smith", "4567890123", 789012, "Location C", "alice@example.com", "secret789",false));
        add(new GymOwner("Ashish Kashyap", "4567890123", 789012, "Location C", "alice@example.com", "secret789",true));

        // Add more gym owners as needed
    }


    static List<GymOwner> gymOwnerList=new ArrayList<>();


    public void add(GymOwner gymOwner) {
        gymOwnerList.add(gymOwner);

    }
    public List<GymOwner> getAllGymOwners() {
        return gymOwnerList;
    }

    public List<GymOwner> viewPendingGymOwnerRequests() {
        List<GymOwner> PendingGymOwners = new ArrayList<>();
        for(GymOwner gymOwner:gymOwnerList){
            if(!gymOwner.isApproved()){
                PendingGymOwners.add(gymOwner);
            }
        }
        return PendingGymOwners;
    }

    public void approve(int gymOwnerId) {
        for(GymOwner gymOwner:gymOwnerList){
            if(gymOwner.getOwnerId()==gymOwnerId){
                gymOwner.setApproved(true);
            }
        }
    }
}
