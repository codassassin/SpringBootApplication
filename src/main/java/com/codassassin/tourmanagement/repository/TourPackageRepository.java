package com.codassassin.tourmanagement.repository;

import com.codassassin.tourmanagement.model.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public interface TourPackageRepository extends JpaRepository<TourPackage, Long> {
    TourPackage getTourById(long tourId);
    void deleteTourById(long tourId);
}
