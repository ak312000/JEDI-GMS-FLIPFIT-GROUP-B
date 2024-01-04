package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDao {

    static List<GymOwner> gymOwnerList=new ArrayList<>();


    public void add(GymOwner gymOwner) {
        System.out.println("gymowner added");
        gymOwnerList.add(gymOwner);
        System.out.println("gymowner dao added ");

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

}
