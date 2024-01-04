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
        add(new GymCenter(1, "Fitness Hub", "A@gmail.com", true, "Location", 100));
        add(new GymCenter(2, "Power Fitness", "b@gmail.com", true, "ownerB@example.com", 200));
        add(new GymCenter(3, "Gym World", "c@gmail.com", true, "ownerC@example.com", 87));
        // Add more gym centers as needed
    }

    private void add(GymCenter gymCenter) {
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
