package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
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

    public List<TimeSlot> viewAllSlots(int gymId) {
        List<TimeSlot> timeSlotOfAGym = new ArrayList<>();
        for(TimeSlot timeSlot:timeSlotList){
            if(timeSlot.getGymId()==gymId){
                timeSlotOfAGym.add(timeSlot);
            }
        }
        return timeSlotOfAGym;
    }

    public void addCustomer(int id,int slotId) {
        for(TimeSlot timeSlot:timeSlotList){
            if(timeSlot.getSlotId()==slotId){
                timeSlot.getCustomerId().add(id);
            }
        }
    }

    public void cancelCustomer(int id,int slotId) {

    }
}
