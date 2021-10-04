package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.repository.TourPackageRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class TourPackageRepositoryImpl implements TourPackageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public TourPackage getTourById(long tourId) {
        assert false;
        Query query = entityManager.createQuery("SELECT t FROM TourPackage t WHERE t.id=:tourId");
        query.setParameter("tourId", tourId);
        List<TourPackage> tourPackageList = query.getResultList();
        if(tourPackageList.size() > 0) {
            return tourPackageList.get(0);
        }
        return null;
    }

    @Override
    public void deleteTourById(long tourId) {
        Query query = entityManager.createQuery("DELETE t FROM TourPackage t WHERE t.id=:tourId");
        query.setParameter("tourId", tourId);
        query.executeUpdate();
    }
}
