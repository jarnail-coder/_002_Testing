/**
 * 
 */
package com.dineshonjava.sdjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.sdjpa.models.Booking;
import com.dineshonjava.sdjpa.service.BookingService;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
@RequestMapping("/booking")
public class BookingController {

	// @Autowired
	// BookingRepository bookingRepository;

	@Autowired
	BookingService bookingService;

	/**
	 * GET /create --> Create a new booking and save it in the database.
	 */
	@RequestMapping("/create")
	public Booking create(@RequestBody Booking booking) {
		return bookingService.save(booking);
	}

	/**
	 * GET /read --> Read a booking by booking id from the database.
	 */
	@RequestMapping("/read")
	public Booking read(@RequestParam(name="id") Long bookingId) {
		return bookingService.find(bookingId);
	}

	/**
	 * GET /update --> Update a booking record and save it in the database.
	 */
	@RequestMapping("/update")
	public Booking update(@RequestParam Long bookingId, @RequestParam String psngrName) {
		return bookingService.update(bookingId, psngrName);
	}

	/**
	 * GET /delete --> Delete a booking from the database.
	 */
	@RequestMapping("/delete")
	public String delete(@RequestParam Long bookingId) {
		bookingService.delete(bookingId);
		return "booking #" + bookingId + " deleted successfully";
	}
}
