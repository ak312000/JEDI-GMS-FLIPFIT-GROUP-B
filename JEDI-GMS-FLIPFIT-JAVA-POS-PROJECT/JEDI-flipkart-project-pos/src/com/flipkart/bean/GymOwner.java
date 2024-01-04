package com.flipkart.bean;

public class GymOwner {
    private static int startId=100;
    private int ownerId;
    private String ownerName;
    private String ownerEmailAddress;

    private String ownerPhone;
    private int ownerGSTNum;

    public static int getStartId() {
        return startId;
    }

    public static void setStartId(int startId) {
        GymOwner.startId = startId;
    }


    private boolean isApproved;
    private String ownerAddress;


    public GymOwner(String ownerName, String ownerPhone, int ownerGSTNum, String ownerAddress, String email, String password) {
        this.ownerEmailAddress=email;
        this.ownerGSTNum = ownerGSTNum;
        this.ownerId=startId++;
        this.ownerName = ownerName;
        this.ownerPhone = ownerPhone;
        this.ownerGSTNum = ownerGSTNum;
        this.ownerAddress = ownerAddress;
        this.password=password;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public int getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    public String getOwnerName() {
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }
    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }
    public String getOwnerPhone() {
        return ownerPhone;
    }
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    public int getOwnerGSTNum() {
        return ownerGSTNum;
    }
    public void setOwnerGSTNum(int ownerGSTNum) {
        this.ownerGSTNum = ownerGSTNum;
    }
    public boolean isApproved() {
        return isApproved;
    }
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    public String getOwnerAddress() {
        return ownerAddress;
    }
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

}


