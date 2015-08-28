/**
 * 
 */
package com.nerdery.snafoo.controllers;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackShopViewModel;
import com.nerdery.snafoo.repository.SnackRepository;
import com.nerdery.snafoo.repository.SnackShopRepository;
import com.nerdery.snafoo.services.SnackShopPageService;

/**
 * Abstract controller for all 'SnackShopJPAModel' related controllers
 * @author string
 *
 */
public class AbstractSnackShopController implements Logging{

	protected ConversionService converterService;
	protected SnackShopPageService snackShopPageService;
	protected SnackShopRepository snackShopRepository;
	protected SnackRepository snackRepository;
	
	protected SnackShopViewModel convert(List<SnackPageModel> domainPage) {
		SnackShopViewModel snackShopInfo = converterService.convert(domainPage, SnackShopViewModel.class);
		return snackShopInfo;
	}

	protected List<SnackPageModel> getRESTDomainPage() {
		List<SnackPageModel> domainPage = snackShopPageService.fetchSnackShopHomePage();
		return domainPage;
	}
	
	/**
	 * Fetch a SnackJPAModel from the local db. 
	 * This is sub-optimal in that it really should be a query in the repo itself, 
	 * and not just a linear search.
	 * @param name
	 * @return the snack instance if found.
	 * @throws SnackNotFoundException
	 */
	public SnackJPAModel findSnackByName(String name) throws SnackNotFoundException {
		Iterable<SnackJPAModel> snacks = snackRepository.findAll();
		for (SnackJPAModel s : snacks) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		throw new SnackNotFoundException(name);
	}
	
	/**
	 * Fetch a SnackJPAModel from the local db using the given id. 
	 * This is sub-optimal in that it really should be a query in the repo itself, 
	 * and not just a linear search.
	 * @param name
	 * @return the snack instance if found.
	 * @throws SnackNotFoundException
	 */
	public SnackJPAModel findSnackById(Long id) throws SnackNotFoundException {
		Iterable<SnackJPAModel> snacks = snackRepository.findAll();
		for (SnackJPAModel s : snacks) {
			if (s.getId().equals(id)) {
				return s;
			}
		}
		throw new SnackNotFoundException(String.valueOf(id));
	}
	
	/**
	 * Save a SnackJPAModel to the local DB.
	 * @param snack
	 */
	public SnackJPAModel save(SnackJPAModel snack){
		return snackRepository.save(snack);
	}

	/**
	 * Create a new SnackJPAModel instance and store in the local DB.
	 * @param name
	 * @return the new snack.
	 */
	protected SnackJPAModel createSnack(String name) {
		getLogger().debug("Creating new snack in the local DB");
		SnackJPAModel snack = new SnackJPAModel(name);
		snack.setSuggestionDate(new Date());
		return snackRepository.save(snack);
	}

	public SnackShopPageService getSnackShopPageService() {
		return snackShopPageService;
	}

	@Inject
	public void setSnackShopPageService(SnackShopPageService snackShopPageService) {
		this.snackShopPageService = snackShopPageService;
	}

	public ConversionService getConverterService() {
		return converterService;
	}

	@Inject
	@Qualifier("customConversionService")
	public void setConverterService(ConversionService converterService) {
		this.converterService = converterService;
	}

	public SnackShopRepository getSnackShopRepository() {
		return snackShopRepository;
	}

	@Inject
	public void setSnackShopRepository(SnackShopRepository snackShopRepository) {
		this.snackShopRepository = snackShopRepository;
	}


	public SnackRepository getSnackRepository() {
		return snackRepository;
	}

	@Inject
	public void setSnackRepository(SnackRepository snackRepository) {
		this.snackRepository = snackRepository;
	}

}
