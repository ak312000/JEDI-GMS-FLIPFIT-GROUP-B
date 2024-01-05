package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreDao {

    private static List<GymCenter> gymCenters = new ArrayList<>();

    // Constructor to initialize gym centers
    public FlipFitGymCentreDao() {
        initializeGymCenters();
    }

    private void initializeGymCenters() {
        add(new GymCenter( "Fitness Hub", "A@gmail.com", "Location", 100));
        add(new GymCenter( "Power Fitness", "b@gmail.com" , "ownerB@example.com", 200));
        add(new GymCenter( "Gym World", "c@gmail.com", "ownerC@example.com", 87));
        // Add more gym centers as needed
    }

    public void add(GymCenter gymCenter) {
        gymCenters.add(gymCenter);
    }

    public List<GymCenter> getGymCenters() {
        return gymCenters;
    }

    public List<GymCenter> viewPendingGymCentreRequests() {
        List<GymCenter> pendingGymCenters = new ArrayList<>();
        for (GymCenter gymCenter : gymCenters) {
            if (!gymCenter.isApproved()) {
                pendingGymCenters.add(gymCenter);
            }
        }
        return pendingGymCenters;
    }

    public List<GymCenter> searchGymsByLocation(String location) {
        List<GymCenter> gymsInLocation = new ArrayList<>();

        for (GymCenter gym : gymCenters) {
            if (gym.getGymLocation().equalsIgnoreCase(location)) {
                gymsInLocation.add(gym);
            }
        }

        return gymsInLocation;
    }

    public void approve(Integer id) {
        for(GymCenter gymCenter:gymCenters){
            if(gymCenter.getId()==id){
                gymCenter.setApproved(true);
            }
        }
    }

    public List<GymCenter> viewApprovedGymCentres() {
        List<GymCenter> ApprovedGymCentres = new ArrayList<>();
        for(GymCenter gymCenter:gymCenters){
            if(gymCenter.isApproved()){
                ApprovedGymCentres.add(gymCenter);
            }
        }
        return ApprovedGymCentres;
    }
}
