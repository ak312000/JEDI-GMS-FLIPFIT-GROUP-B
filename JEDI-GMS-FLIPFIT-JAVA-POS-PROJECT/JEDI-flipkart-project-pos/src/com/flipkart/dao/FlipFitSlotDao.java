package com.flipkart.dao;

import com.flipkart.bean.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class FlipFitSlotDao {
    static List<TimeSlot> timeSlotList=new ArrayList<>();
    public void add(TimeSlot timeSlot) {
        System.out.println("slot added");
        timeSlotList.add(timeSlot);
        System.out.println("slot dao added ");
    }

    public List<TimeSlot> viewAllSlots() {
        return timeSlotList;
    }
}
