package org.exoplatform.dao;

import org.exoplatform.commons.api.persistence.GenericDAO;
import org.exoplatform.model.FavouriteActivityEntity;

import java.util.List;

public interface FavouriteActivityDAO extends GenericDAO<FavouriteActivityEntity, Long> {
    public List<FavouriteActivityEntity> getFavouritActivitybyName(String Title);
}
