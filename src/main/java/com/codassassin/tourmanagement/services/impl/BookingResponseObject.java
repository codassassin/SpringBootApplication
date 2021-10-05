package com.codassassin.tourmanagement.services.impl;

import com.codassassin.tourmanagement.model.Bookings;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponseObject {

    @JsonProperty
    Boolean status;

    @JsonProperty
    String error;

    @JsonProperty
    Bookings booking;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }
}
