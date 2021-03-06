package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.BookingRepository;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import com.codassassin.tourmanagement.repository.UserRepository;
import com.codassassin.tourmanagement.services.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Bookings> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Bookings getBooking(long id) {
        return bookingRepository.getBookingById(id);
    }

    @Override
    public Bookings saveBooking(SaveBookingRequest request) throws Exception {
        long userId = request.getUserId();
        long tourId = request.getTourPackageId();


        Bookings booking = new Bookings();
        User user = userRepository.getUserById(userId);
        TourPackage tourPackage = tourPackageRepository.getTourById(tourId);


        if((tourPackage.getSeats() - request.getNumberOfSeats()) < 0) {
            throw new Exception(String.format("Seats full for %s, only %d seats available",
                    tourPackage.getPackageName(), request.getNumberOfSeats()));
        } else {
            tourPackage.setSeats(tourPackage.getSeats() - request.getNumberOfSeats());
        }

        booking.setBookedOn(request.getBookedOn());
        booking.setValid(request.getValid());
        booking.setCancelledOn(request.getCancelledOn());
        booking.setNumberOfSeats(request.getNumberOfSeats());
        booking.setUser(user);
        booking.setTourPackage(tourPackage);
        return bookingRepository.save(booking);
    }

    @Override
    public Bookings updateBooking(Bookings booking, long id) {
        Bookings existingBooking = bookingRepository.getBookingById(id);

        if(booking.getBookedOn() != null) {
            existingBooking.setBookedOn(booking.getBookedOn());
        }

        if(booking.getCancelledOn() != null) {
            existingBooking.setCancelledOn(booking.getCancelledOn());
        }

        if(booking.getIsValid() != null) {
            existingBooking.setIsValid(booking.getIsValid());
        }

        bookingRepository.save(existingBooking);
        return existingBooking;
    }

    @Override
    public void deleteBooking(long id) {
        Bookings newBooking = bookingRepository.getBookingById(id);
        bookingRepository.delete(newBooking);
    }
}
