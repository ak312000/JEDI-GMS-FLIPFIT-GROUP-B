package com.flipkart.bean;

public class Admin {
    private static int startId=100;
    private int adminId;
    private String adminName;
    private String adminEmailAddress;
    private String phone;
    private String password;

    public Admin(int adminId) {

    }

    public Admin(String name, String emailAddress, String phone, String password) {
        this.adminId = startId++;
        this.adminName=name;
        this.adminEmailAddress=emailAddress;
        this.phone=phone;
        this.password=password;
    }

    public String getAdminPhone() {
        return phone;
    }

    public void setAdminPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmailAddress() {
        return adminEmailAddress;
    }

    public void setAdminEmailAddress(String adminEmailAddress) {
        this.adminEmailAddress = adminEmailAddress;
    }
}
