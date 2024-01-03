package com.flipkart.dao;

import com.flipkart.bean.GymCenter;

import java.util.List;

public interface CutomerDaoInterface {
    public List<GymCenter> fetchGymList();

    public void fetchSlotList(int gymId);

    public void fetchBookedSlots(String email);

    public void bookSlots(int gymId, String slotId,String customerId,String date);

    public boolean isFull(String slotId,String date);

    public boolean alreadyBooked(String slotId, String email, String date);

    public void cancelBooking(String slotId, String email, String date);

    public boolean checkSlotExists(String slotId, int gymId);

    public void cancelBookedSlots(String email, int bookingId);

    public boolean checkGymApprove(int gymId);
}
