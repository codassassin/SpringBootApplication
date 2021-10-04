package com.codassassin.tourmanagement.repository.impl;

import com.codassassin.tourmanagement.model.Tags;
import com.codassassin.tourmanagement.repository.TagsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public abstract class TagsRepositoryImpl implements TagsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Tags getTagsById(long tagId) {
        assert false;
        Query query = entityManager.createQuery("SELECT t FROM tags WHERE t.id = :tagId");
        query.setParameter("tagId", tagId);
        List<Tags> tagsList = query.getResultList();
        if(tagsList.size() > 0) {
            return tagsList.get(0);
        }
        return null;
    }

    @Override
    public void deleteTagById(long tagId) {
        Query query = entityManager.createQuery("DELETE FROM bookings WHERE id = :tagId");
        query.setParameter("tagId", tagId);
        query.executeUpdate();
    }
}
