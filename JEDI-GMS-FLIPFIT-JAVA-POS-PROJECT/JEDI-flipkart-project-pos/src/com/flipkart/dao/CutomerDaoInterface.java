package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;

import java.util.List;

public interface CutomerDaoInterface {

    public void add(Customer customer);
    public List<Customer> getAllCustomers();
    public  Customer getCustomerByemail(String email);
    public Customer getCustomerById(Integer id);
    public void updateCustomer(Customer updatedCustomer);

    public int getIDFromEmail(String email, String password);
    public void addBooking(Booking booking, int id);
    public List<Booking> getAllBooking(int id);
//    public List<GymCenter> fetchGymList();
//
//    public void fetchSlotList(int gymId);
//
//    public void fetchBookedSlots(String email);
//
//    public void bookSlots(int gymId, String slotId,String customerId,String date);
//
//    public boolean isFull(String slotId,String date);
//
//    public boolean alreadyBooked(String slotId, String email, String date);
//
//    public void cancelBooking(String slotId, String email, String date);

//    public boolean checkSlotExists(String slotId, int gymId);
//
//    public void cancelBookedSlots(String email, int bookingId);
//
//    public boolean checkGymApprove(int gymId);
}
