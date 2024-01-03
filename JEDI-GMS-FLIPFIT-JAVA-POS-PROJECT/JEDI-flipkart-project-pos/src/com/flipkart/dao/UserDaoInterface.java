package com.flipkart.dao;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

public interface UserDaoInterface {
    public User isAuthenticated(User userData);

    public void registerCustomer(Customer customerData);

    public void registerGymOwner(GymOwner ownerData);

    public void registerUser(User userData);
}
