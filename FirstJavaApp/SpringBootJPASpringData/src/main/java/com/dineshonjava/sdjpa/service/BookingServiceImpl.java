package com.dineshonjava.sdjpa.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineshonjava.sdjpa.models.Booking;
import com.dineshonjava.sdjpa.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking save(Booking booking) {
		booking.setTravelDate(new Date());
		booking = bookingRepository.save(booking);
		return booking;
	}

	@Override
	public Booking find(Long bookingId) {
		return bookingRepository.findOne(bookingId);
	}

	@Override
	public Booking update(Long bookingId, String psngrName) {
		Booking booking = bookingRepository.findOne(bookingId);
		booking.setPsngrName(psngrName);
		booking = bookingRepository.save(booking);
		return booking;
	}

	@Override
	public void delete(Long bookingId) {
		bookingRepository.delete(bookingId);
	}

}
