package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class FlipFitBookingDao {
    static List<Booking> bookings=new ArrayList<>();
    public void add(Booking booking){
        bookings.add(booking);
    }

    public void cancleBooking(int bookingId) {
        for(Booking booking:bookings){
            if(booking.getId()==bookingId){
                booking.setStatus(false);
            }
        }
    }
}
