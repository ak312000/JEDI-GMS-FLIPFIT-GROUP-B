package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreDao {
    static List<GymCenter> gymCenters = new ArrayList<>();
    public void add(GymCenter gymCenter) {
        gymCenters.add(gymCenter);

    }
    public List<GymCenter> getGymCenters() {
        return gymCenters;
    }

    public List<GymCenter> viewPendingGymCentreRequests() {
        List<GymCenter> PendingGymCentres = new ArrayList<>();
        for(GymCenter gymCenter:gymCenters){
            if(!gymCenter.isApproved()){
                PendingGymCentres.add(gymCenter);
            }
        }
        return PendingGymCentres;
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
