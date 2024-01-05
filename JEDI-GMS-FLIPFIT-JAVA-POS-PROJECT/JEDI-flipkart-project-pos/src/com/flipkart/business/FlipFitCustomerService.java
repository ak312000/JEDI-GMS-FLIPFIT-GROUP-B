package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.dao.FlipFitBookingDao;
import com.flipkart.dao.FlipFitCustomerDao;
import com.flipkart.dao.FlipFitGymCentreDao;
import com.flipkart.dao.FlipFitSlotDao;

import java.util.*;

public class FlipFitCustomerService {
    FlipFitCustomerDao customerDatabase = new FlipFitCustomerDao();
    FlipFitGymCentreDao flipFitGymCentreDao=new FlipFitGymCentreDao();
    FlipFitBookingDao flipFitBookingDao = new FlipFitBookingDao();
    FlipFitSlotDao flipFitSlotDao = new FlipFitSlotDao();

    public void createCustomer(String name, String address,String emailAddress, String phone, String password) {
        Customer customer = new Customer(name,address,emailAddress,phone,password);
        customerDatabase.add(customer);
        System.out.println("customer added Successfully");
    }
    public void editCustomer( )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the customer Id you want to update");
        Integer customerId=in.nextInt();

        System.out.print("Enter new name: ");
        String newName = in.nextLine();

        System.out.print("Enter new address: ");
        String newAddress = in.nextLine();

        System.out.print("Enter new email address: ");
        String newEmail = in.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhone = in.nextLine();

        in.nextLine();

        System.out.print("Enter new password: ");
        String newPassword = in.nextLine();


        Customer customer = customerDatabase.getCustomerById(customerId);

        if (customer != null) {
            // Update customer attributes
            customer.setCustomerName(newName);
            customer.setCustomerAddress(newAddress);
            customer.setCustomerEmailAddress(newEmail);
            customer.setCustomerPhone(newPhone);

            // Save the changes to the DAO layer
            customerDatabase.updateCustomer(customer);

            System.out.println("Customer details updated successfully.");
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }

    }
    public void bookSlot(String gym) {
        Map<String, List<String>> gymMap = new HashMap<>();

        List<String> slotsGym1 = new ArrayList<>(Arrays.asList("10:00 AM", "2:00 PM", "5:00 PM"));
        List<String> slotsGym2 = new ArrayList<>(Arrays.asList("9:00 AM", "1:00 PM", "4:00 PM"));
        List<String> slotsGym3 = new ArrayList<>(Arrays.asList("11:00 AM", "3:00 PM", "6:00 PM"));

        gymMap.put("Gym1", slotsGym1);
        gymMap.put("Gym2", slotsGym2);
        gymMap.put("Gym3", slotsGym3);

        List<String> presentSlot = gymMap.get(gym);
        System.out.println("Available slots at " + gym);
        int op = 1;

        for(String slot : presentSlot){
            System.out.println("Option " + op + ": " + slot);
            op++;
        }

        System.out.println("Choose slot option: ");
        Scanner in = new Scanner(System.in);
        String option = in.next();
        System.out.println("Slot booked successfully");

        gymMap.get(gym).remove(option);
    }

    public void searchGym(String location) {
        Map<String, String> gymMap = new HashMap<>();

        gymMap.put("Location1", "Gym1");
        gymMap.put("Location2", "Gym2");
        gymMap.put("Location3", "Gym3");

        String selectedGym = gymMap.get(location);

        if (selectedGym != null) {
            System.out.println("Gym Found: " + selectedGym);
        } else {
            System.out.println("No gym found at the specified location.");
        }
        bookSlot(selectedGym);
    }

    public void viewCustomerProfile(String email){
        Customer customer = customerDatabase.getCustomerByemail(email);

        if (customer != null) {
            // Display customer details
            System.out.println("Customer ID: " + customer.getCustomerId());
            System.out.println("Name: " + customer.getCustomerName());
            System.out.println("Address: " + customer.getCustomerAddress());
            System.out.println("Email: " + customer.getCustomerEmailAddress());
            System.out.println("Phone: " + customer.getCustomerPhone());

            // Additional attributes can be added based on your Customer class
        } else {
            System.out.println("Customer not found with ID: " + email);
        }
    }

    public boolean viewAllGymCenters(int id) {
        System.out.println("view All Gym Centers");
        return true;
    }

    public void isAlreadyBooked() {
        System.out.println("is Already Booked");
    }

    public void cancelSlot() {
        System.out.println("cancel Slot");
    }

    public void viewAllBookings(String email,String password) {
        int id=customerDatabase.getIDFromEmail(email,password);
        List<Booking> bookings= customerDatabase.getAllBooking(id);
        if (bookings != null ) {
            for (Booking booking: bookings){

                    System.out.println("Booking ID: " + booking.getId());
                    System.out.println("CustID: " + booking.getCustId());
                    System.out.println("Centre Id: " + booking.getGymCentreId());
                    System.out.println("Slot ID: " + booking.getSlotId());
                    System.out.println("status: " + booking.isStatus());

            }

        } else {
            System.out.println("Customer not found with ID: " + email);
        }
    }


    public boolean isValidCustomerCredentials( String customerEmail, String customerPassword) {
        List<Customer> allCustomers = customerDatabase.getAllCustomers();
        for (Customer customer : allCustomers) {
            if (customer.getCustomerEmailAddress().equals(customerEmail) && customer.getPassword().equals(customerPassword)) {
                return true; // Credentials are valid
            }
        }
        return false; // No matching customer found
    }

    public void searchAllGyms() {

        List<GymCenter> allGyms =flipFitGymCentreDao.getGymCenters();

        if (allGyms.isEmpty()) {
            System.out.println("No gyms available.");
        } else {
            System.out.println("List of all gyms:");
            for (GymCenter gym : allGyms) {
                System.out.println("Gym ID: " + gym.getId());
                System.out.println("Gym Name: " + gym.getGymName());
                System.out.println("Gym Address: " + gym.getGymLocation());
                // Add more attributes as needed
                System.out.println();
            }
        }

    }
    public void searchGymOnLocation(String location) {

        List<GymCenter> gymsByLocation = flipFitGymCentreDao.searchGymsByLocation(location);

        if (gymsByLocation.isEmpty()) {
            System.out.println("No gyms found in the specified location: " + location);
        } else {
            System.out.println("List of gyms in location " + location + ":");
            for (GymCenter gym : gymsByLocation) {
                System.out.println("Gym ID: " + gym.getId());
                System.out.println("Gym Name: " + gym.getGymName());
                System.out.println("Gym Address: " + gym.getGymLocation());
                // Add more attributes as needed
                System.out.println();
            }
        }

    }

    public void makeBooking(String email, String password) {
        int id=customerDatabase.getIDFromEmail(email,password);
        if(id==0) {
            System.out.println("No customer with this email");
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Enter gymCentreId: ");
        int gymCentreId = in.nextInt();
        System.out.println("Enter Slot Id: ");
        int  slotId= in.nextInt();
        System.out.println("Enter date  ");
        String  date= in.nextLine();

        Booking booking = new Booking(id,gymCentreId,slotId,email,date);
        customerDatabase.addBooking(booking,id);
        flipFitSlotDao.addCustomer(id,slotId);

    }

    public void cancleBooking(int bookingId,String email,String password,int slotId) {
        int id=customerDatabase.getIDFromEmail(email,password);
        if(id==0) {
            System.out.println("No customer with this email");
        }
        flipFitBookingDao.cancleBooking(bookingId);
        flipFitSlotDao.cancelCustomer(id,slotId);
    }
}
