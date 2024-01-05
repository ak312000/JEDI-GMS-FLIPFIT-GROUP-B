package com.flipkart.bean;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TimeSlot {
    static int slotIdNum = 100;
    private int gymId;


    public TimeSlot(int gymId, String day, String start, String end) {
        this.slotId = slotIdNum++;
        this.day=day;
        this.gymId=gymId;
        this.startTime=  start;
        this.endTime=  end;
    }

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
    private int slotId;
    private String day;
    private final List<Integer> customerId = new ArrayList<>();
    private String startTime;
    private String endTime;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getCustomerId() {
        return customerId;
    }
}
