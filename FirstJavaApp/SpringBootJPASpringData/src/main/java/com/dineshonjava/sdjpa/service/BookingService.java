package com.dineshonjava.sdjpa.service;

import org.springframework.stereotype.Service;

import com.dineshonjava.sdjpa.models.Booking;

@Service
public interface BookingService {
	Booking save(Booking booking);

	Booking find(Long bookingId);

	Booking update(Long bookingId, String psngrName);

	void delete(Long bookingId);
}
