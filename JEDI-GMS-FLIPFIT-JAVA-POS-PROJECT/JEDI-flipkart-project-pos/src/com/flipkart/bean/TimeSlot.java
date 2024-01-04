package com.flipkart.bean;

import java.util.List;

public class TimeSlot {
    private int gymId;
    public int getGymId() {
        return gymId;
    }
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }
    public int getSlotId() {
        return slotId;
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    private int slotId;
    private int date;
    private List<Integer> customerId;
    private String time;

    public List<Integer> getCustomerId() {
        return customerId;
    }

    public void setCustomerId(List<Integer> customerId) {
        this.customerId = customerId;
    }
}
