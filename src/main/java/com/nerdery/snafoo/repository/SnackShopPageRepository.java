package com.nerdery.snafoo.repository;

import java.util.List;

import com.nerdery.snafoo.model.domain.jpa.Todo;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.services.WebServicePostException;

/**
 * Base interface for respositories providing access SnackShopJPAModel models. 
 */
public interface SnackShopPageRepository {
    List<SnackPageModel> getSnackShopHomePage();
	Todo addSuggestion(Todo snack) throws WebServicePostException;
}
