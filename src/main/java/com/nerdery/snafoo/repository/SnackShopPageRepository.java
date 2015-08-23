package com.nerdery.snafoo.repository;

import java.util.List;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;

/**
 * Base interface for respositories providing access SnackShop models. 
 */
public interface SnackShopPageRepository {
    List<SnackPageModel> getSnackShopHomePage();
}
