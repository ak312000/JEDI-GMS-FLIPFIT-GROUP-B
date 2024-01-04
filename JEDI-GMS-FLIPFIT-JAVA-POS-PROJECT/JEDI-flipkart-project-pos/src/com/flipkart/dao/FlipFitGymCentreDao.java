package com.flipkart.dao;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;

public class FlipFitGymCentreDao {
    static List<GymCenter> gymCenters = new ArrayList<>();
    public void add(GymCenter gymCenter) {
        gymCenters.add(gymCenter);

    }
}
