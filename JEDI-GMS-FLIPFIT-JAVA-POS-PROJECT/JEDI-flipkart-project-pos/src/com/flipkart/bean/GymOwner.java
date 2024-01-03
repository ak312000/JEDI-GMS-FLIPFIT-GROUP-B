package com.flipkart.bean;

public class GymOwner {
    private String name;
    private String address;
    private String IDProof;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIDProof() {
        return IDProof;
    }

    public void setIDProof(String IDProof) {
        this.IDProof = IDProof;
    }

    public String getGymOwnerID() {
        return gymOwnerID;
    }

    public void setGymOwnerID(String gymOwnerID) {
        this.gymOwnerID = gymOwnerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String gymOwnerID;


}
