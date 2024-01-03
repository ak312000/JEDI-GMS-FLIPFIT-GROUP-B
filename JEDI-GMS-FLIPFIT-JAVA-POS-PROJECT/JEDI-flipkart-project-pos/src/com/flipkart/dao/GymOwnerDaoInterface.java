package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.TimeSlot;

import java.util.List;

public interface GymOwnerDaoInterface {
    public GymOwner fetchOwnerDetails(String gymOwnerId);

//	public void addGymOwnerDetails(GymOwner gymOwnerDetails);

    public List<GymCenter> fetchGymDetails(String gymOwnerId);

    public void addGymDetails(GymCenter gymDetails);

    public List<TimeSlot> fetchPossibleSlots();

    public void addSlots(int gymId, String chosenSlots, List<TimeSlot> slotInfo);

    public boolean checkOwnerApproval(String email);

    public boolean checkGymApproval(int gymId);

    public boolean checkIfAlreadyBooked(int gymId);
}
