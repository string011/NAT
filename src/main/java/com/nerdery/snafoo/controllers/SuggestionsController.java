package com.nerdery.snafoo.controllers;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackModel;
import com.nerdery.snafoo.model.view.SnackShopModel;
import com.nerdery.snafoo.model.view.SuggestionModel;
import com.nerdery.snafoo.model.view.SuggestionsModel;
import com.nerdery.snafoo.services.SnackShopPageService;

/**
 * Controller for the "suggestions" page.
 * Might be a good idea to make an abstract base class for controllers 
 * to avoid duplicate code.
 * 
 * @author string
 *
 */
@Controller
public class SuggestionsController {
	private ConversionService converterService;
	private SnackShopPageService snackShopPageService;

    @RequestMapping(value = "/suggestions", method=RequestMethod.GET)
    public String renderPage(Model model) {
		List<SnackPageModel> domainPage = snackShopPageService.fetchSnackShopHomePage();
		SnackShopModel snackShopInfo = converterService.convert(domainPage, SnackShopModel.class);
		
		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
        return "suggestions";
    }

    
	@RequestMapping(value = "/suggestion", method = RequestMethod.POST)
    public String handleSuggestion(@ModelAttribute SuggestionsModel suggestions, Model model) {
		List<SnackPageModel> domainPage = snackShopPageService.fetchSnackShopHomePage();
		SnackShopModel snackShopInfo = converterService.convert(domainPage, SnackShopModel.class);
		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
        return "suggestions";
    }
	
	protected SuggestionsModel createSuggestionsModel(SnackShopModel snackShopInfo) {
		SuggestionsModel ssm = new SuggestionsModel();
		for (SnackModel sm : snackShopInfo.getSnacks()){
			if (sm.getPurchaseCount() == 0){
				SuggestionModel smx = new SuggestionModel();
				smx.setName(sm.getName());
				smx.setLocation(sm.getPurchaseLocations());
				ssm.add(smx);
			}
		}
		return ssm;
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
}