package com.codassassin.tourmanagement.services.impl;


import com.codassassin.tourmanagement.model.TourPackage;
import com.codassassin.tourmanagement.model.User;
import com.codassassin.tourmanagement.repository.TourPackageRepository;
import com.codassassin.tourmanagement.services.ITourPackageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class TourPackageServiceImpl implements ITourPackageService {

    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Override
    public List<TourPackage> getAllTourPackages() {
        return tourPackageRepository.findAll();
    }

    @Override
    public TourPackage getTourPackage(long id) {
        return tourPackageRepository.getTourById(id);
    }

    public TourPackage saveTourPackage(TourPackage tourpackage) {
        return tourPackageRepository.save(tourpackage);
    }

    @Override
    public TourPackage updateTourPackage(TourPackage tourpackage, long id) {
        TourPackage existingTourPackage = tourPackageRepository.getTourById(id);

        if(tourpackage.getPackageName() != null) {
            existingTourPackage.setPackageName(tourpackage.getPackageName());
        }
        if(tourpackage.getDuration() != null) {
            existingTourPackage.setDuration(tourpackage.getDuration());
        }
        if(Integer.toString(tourpackage.getPrice()) != null) {
            existingTourPackage.setPrice(tourpackage.getPrice());
        }

        tourPackageRepository.save(existingTourPackage);
        return existingTourPackage;
    }

    @Override
    public void deleteTourPackage(long id) {
        TourPackage newTour =  tourPackageRepository.getTourById(id);
        tourPackageRepository.delete(newTour);
    }
}
