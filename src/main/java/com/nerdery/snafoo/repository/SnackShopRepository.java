package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.SnackShopJPAModel;

/**
 * Base interface for SnackShopJPAModel
 */
public interface SnackShopRepository {
    Iterable<SnackShopJPAModel> findAll();
    SnackShopJPAModel save(SnackShopJPAModel snackShop);
}
