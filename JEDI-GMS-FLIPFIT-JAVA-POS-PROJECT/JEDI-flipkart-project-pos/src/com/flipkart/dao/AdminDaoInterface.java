package com.flipkart.dao;

import com.flipkart.bean.Admin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;

public interface AdminDaoInterface{

    public void add(Admin admin);
    public List<Admin> getAllAdmins();

//    public List<GymOwner> seeAllGymOwner();
//
//    public List<GymCenter> seeAllGyms();
//
//    public List<GymOwner> seePendingGymOwnerRequest();
//
//    public List<GymCenter> seePendingGymRequest();
//
//    public void approveSingleOwnerRequest(String requestId);
//
//    public void approveAllOwnerRequest();
//
//    public void approveSingleGymRequest(int gymId);
//
//    public void approveAllGymRequest();
}
