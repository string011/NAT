package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.rest.SnackShopPageModel;

/**
 * Base interface for respositories providing access SnackShop models. 
 */
public interface SnackShopPageRepository {
    SnackShopPageModel getSnackShopHomePage();
}
