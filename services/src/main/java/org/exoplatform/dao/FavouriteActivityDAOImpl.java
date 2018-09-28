package org.exoplatform.dao;

import org.exoplatform.commons.persistence.impl.GenericDAOJPAImpl;
import org.exoplatform.model.FavouriteActivityEntity;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavouriteActivityDAOImpl extends GenericDAOJPAImpl<FavouriteActivityEntity, Long> {

    @Override
    public void delete(FavouriteActivityEntity entity) {
        getEntityManager().refresh(entity);
        super.delete(entity);
    }
    @Override
    public FavouriteActivityEntity create(FavouriteActivityEntity entity) {
        getEntityManager().refresh(entity);
        super.create(entity);
        return entity;
    }
    @Override
    public FavouriteActivityEntity update(FavouriteActivityEntity entity) {
        getEntityManager().refresh(entity);
        super.update(entity);
        return entity;
    }

    public List<FavouriteActivityEntity> getFavouritActivitybyName(String Title) {
        TypedQuery<FavouriteActivityEntity> query = getEntityManager().createNamedQuery("FavouriteActivityEntity.getFavouritActivitybyName", FavouriteActivityEntity.class);
        query.setParameter("favActId", Title);
        try {
            return query.getResultList();
        } catch (NoResultException ex) {
            return null;
        }

    }
}
