package com.flipkart.bean;

public class GymCenter {
    private static int gymCentreIdNum = 100;
    private int gymOwnerId;

    public int getGymOwnerId() {
        return gymOwnerId;
    }

    public void setGymOwnerId(int gymOwnerId) {
        this.gymOwnerId = gymOwnerId;
    }

    private int gymCentreId;
    private String gymName;
    private String gymEmailAddress;
    private boolean isApproved;
    private String gymLocation;
    private int numOfSeats;

    public GymCenter( String gymName, String gymEmailAddress, String gymLocation, int numOfSeats) {
        this.gymCentreId = gymCentreIdNum++;
        this.gymName = gymName;
        this.gymEmailAddress = gymEmailAddress;
        this.isApproved = false;
        this.gymLocation = gymLocation;
        this.numOfSeats = numOfSeats;
    }

//    public GymCenter() {
//        this.gymCentreId = gymCentreIdNum++;
//        this.gymName = null;
//        this.gymEmailAddress = null;
//        this.isApproved = false;
//        this.gymLocation = null;
//        this.numOfSeats = 10;
//
//    }

    public int getId() {
        return gymCentreId;
    }
    public void setId(int id) {
        this.gymCentreId = id;
    }
    public String getGymName() {
        return gymName;
    }
    public void setGymName(String gymName) {
        this.gymName = gymName;
    }
    public String getGymEmailAddress() {
        return gymEmailAddress;
    }
    public void setGymEmailAddress(String gymEmailAddress) {
        this.gymEmailAddress = gymEmailAddress;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public String getGymLocation() {
        return gymLocation;
    }
    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }
    public int getNumOfSeats() {
        return numOfSeats;
    }
    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }
}
