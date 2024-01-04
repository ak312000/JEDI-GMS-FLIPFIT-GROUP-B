package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDao {

    static List<GymOwner> gymOwnerList=new ArrayList<>();


    public void add(GymOwner gymOwner) {
        System.out.println("gymowner added");
        gymOwnerList.add(gymOwner);
        System.out.println("gymowner dao added ");

    }
    public List<GymOwner> getAllGymOwners() {
        // Your database logic to fetch all admins goes here
        // For example, you might use JDBC or an ORM framework

        // For demonstration purposes, let's create a sample list of admins

        return gymOwnerList;
    }
}
