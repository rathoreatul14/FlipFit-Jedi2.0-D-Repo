package com.flipkart.service;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.Gym;
import com.flipkart.dao.CustomerDao;
import com.flipkart.exception.BookingExistsException;
import com.flipkart.exception.SlotFilledException;

import com.flipkart.bean.User;

import java.util.*;

public class CustomerServices implements CustomerServicesInterface {

	CustomerDao dao = new CustomerDao();


	// Registers a new customer
	@Override
	public String registerCustomer(Customer customer) {

			User user = new User(1, customer.getName(), customer.getEmail(), "customer", customer.getPassword());
			int status = dao.registerCustomer(user, customer);
			if(status == 1){
			return "Customer registerd successfully";}
			return "Customer couldn't be registered due to some issue";
	}

	// View details of particular customer
	@Override
	public Customer viewProfile(int id) {
		return dao.viewProfile(id);
	}

	// Update details of a particular customer
	@Override
	public void updateProfile(Customer customer) {
		// TODO Auto-generated method stub

		int custID = customer.getCustomerID();
		Scanner sc = new Scanner(System.in);
		System.out.println("username");
		String newName = sc.next(); //
		System.out.println("Address");
		String newAddress = sc.next();
		customer.setAddress(newAddress);
		customer.setName(newName);
	}

	// View bookings of an user
	@Override
	public List<Booking> viewBookings(int id) {

		return dao.bookedGymList(id);
	}

	// Prints list of all gyms
	@Override
	public ArrayList<Gym> viewGyms() {
		return dao.fetchGymList();
	}

	// To book a slot
	@Override
	public void bookSlot(int slotId, int customerID, int gymID) {
		try {

			if (dao.isFull(slotId)) {
					throw new SlotFilledException();
			} else if (dao.isAlreadyBooked(slotId, customerID)) {
					throw new BookingExistsException();
			} else {
					dao.bookSlots(slotId, customerID, gymID);
					System.out.println("Slot booked successfully!");		
			}
		}catch(Exception Ex) {
			System.out.println(Ex.getMessage());
		}	
	}

	// Fetch list of slots in a gym
	public int fetchSlots(int gymId) {
		return dao.fetchSlotList(gymId);
	}
}
