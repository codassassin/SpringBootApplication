package com.codassassin.tourmanagement.security;

public enum TourPackageRoles {
    OPERATOR("ROLE_createTour"),
//    OPERATOR("ROLE_updateTour"),
    REGISTERED_USER("ROLE_readTour");

    TourPackageRoles(String role_createTour) {
    }
}
