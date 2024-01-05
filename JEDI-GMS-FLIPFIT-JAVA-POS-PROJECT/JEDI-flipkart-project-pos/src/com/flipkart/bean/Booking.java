package com.flipkart.bean;

public class Booking {
    private static int bookingIdNum= 100;
    private int bookingId;
    private int custId;
    private int gymCentreId;
    private int slotId;
    private String custEmail;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Booking(int id, int gymCentreId, int slotId, String email, String date) {
        this.bookingId=bookingIdNum++;
        this.custId=id;
        this.gymCentreId=gymCentreId;
        this.date=date;
        this.custEmail=email;
        this.slotId=slotId;
        this.status=true;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    private String date;

    public int getId() {
        return bookingId;
    }
    public void setId(int id) {
        this.bookingId = id;
    }
    public int getGymCentreId() {
        return gymCentreId;
    }
    public void setGymCentreId(int gymCentreId) {
        this.gymCentreId = gymCentreId;
    }
    public int getSlotId() {
        return slotId;
    }
    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }
    public String getCustEmail() {
        return custEmail;
    }
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
}
