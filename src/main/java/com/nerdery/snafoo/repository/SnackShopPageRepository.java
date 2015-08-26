package com.nerdery.snafoo.repository;

import java.util.List;

import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.services.WebServicePostException;

/**
 * Base interface for respositories providing access SnackShop models. 
 */
public interface SnackShopPageRepository {
    List<SnackPageModel> getSnackShopHomePage();
	Snack addSuggestion(Snack snack) throws WebServicePostException;
}
