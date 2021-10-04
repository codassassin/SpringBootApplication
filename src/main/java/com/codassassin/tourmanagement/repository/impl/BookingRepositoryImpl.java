package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.Bookings;
import com.codassassin.tourmanagement.repository.BookingRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class BookingRepositoryImpl implements BookingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Bookings getBookingById(long bookingId) {
        assert false;
        Query query = entityManager.createQuery("SELECT b FROM Bookings b WHERE b.id = :bookingId");
        query.setParameter("bookingId", bookingId);
        List<Bookings> bookingsList = query.getResultList();
        if(bookingsList.size() > 0) {
            return bookingsList.get(0);
        }
        return null;
    }

    @Override
    public void deleteBookingsById(long bookingId) {
        Query query = entityManager.createQuery("DELETE FROM Bookings b WHERE id = :bookingId");
        query.setParameter("bookingId", bookingId);
        query.executeUpdate();
    }
}
