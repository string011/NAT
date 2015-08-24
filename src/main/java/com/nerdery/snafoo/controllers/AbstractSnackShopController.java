/**
 * 
 */
package com.nerdery.snafoo.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackShopModel;
import com.nerdery.snafoo.repository.SnackShopRepository;
import com.nerdery.snafoo.services.SnackShopPageService;

/**
 * Abstract controller for all 'SnackShop' related controllers
 * @author string
 *
 */
public class AbstractSnackShopController {

	protected ConversionService converterService;
	protected SnackShopPageService snackShopPageService;
	protected SnackShopRepository snackShopRepository;

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

	protected SnackShopModel convert(List<SnackPageModel> domainPage) {
		SnackShopModel snackShopInfo = converterService.convert(domainPage, SnackShopModel.class);
		return snackShopInfo;
	}

	protected List<SnackPageModel> getRESTDomainPage() {
		List<SnackPageModel> domainPage = snackShopPageService.fetchSnackShopHomePage();
		return domainPage;
	}

}
