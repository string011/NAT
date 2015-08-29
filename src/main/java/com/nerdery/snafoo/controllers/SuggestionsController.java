package com.nerdery.snafoo.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.ErrorModel;
import com.nerdery.snafoo.model.view.SnackViewModel;
import com.nerdery.snafoo.model.view.SnackShopViewModel;
import com.nerdery.snafoo.model.view.SuggestionViewModel;
import com.nerdery.snafoo.model.view.SuggestionsViewModel;
import com.nerdery.snafoo.services.WebServicePostException;

/**
 * Controller for the "suggestions" page. Might be a good idea to make an
 * abstract base class for controllers to avoid duplicate code.
 * 
 * @author string
 *
 */
@Controller
public class SuggestionsController extends AbstractSnackShopController {

	@RequestMapping(value = "/suggestions", method = RequestMethod.GET)
	public String renderPage(Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopViewModel snackShopInfo = convert(domainPage);
		SuggestionsViewModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
		return "suggestions";
	}

	@RequestMapping(value = "/suggestion", method = RequestMethod.POST)
	public String handleSuggestion(@ModelAttribute SuggestionsViewModel suggestions, Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopViewModel snackShopInfo = convert(domainPage);
		String error = null;
		if (suggestions.getName() != null && suggestions.getLocation() != null && suggestions.getName().length() != 0) {
			SuggestionViewModel sug = new SuggestionViewModel();
			sug.setName(suggestions.getName());
			sug.setLocation(suggestions.getLocation());
			// post the suggestion to the REST endpoint, and to the local JPA repo.
			error = postSuggestionToWebService(sug);
			// find the matching snack from local DB and create a new instance if necessary.
			/*
			if (error == null) {
				try {
					SnackJPAModel snack = findSnackByName(sug.getName());
					
				} catch (SnackNotFoundException e) {
					// This is here to handle snacks that are 
					// createSnack(sug.getName());
				}
			}
			*/
		} else {
			error = "Name and location are required";
		}
		domainPage = getRESTDomainPage();
		snackShopInfo = convert(domainPage);
		SuggestionsViewModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
		if (error != null) {
			model.addAttribute("xerror", new ErrorModel(error));
		}
		return "suggestions";
	}

	/**
	 * Post a suggestion to the web service. If any errors occur, return an
	 * error message that will be rendered on the view.
	 * 
	 * @param sug
	 * @return an error message or null.
	 */
	private String postSuggestionToWebService(SuggestionViewModel sug) {
		SnackJPAModel snack = new SnackJPAModel();
		snack.setName(sug.getName());
		snack.setLocation(sug.getLocation());
		try {
			getSnackShopPageService().addSuggestion(snack);
		} catch (WebServicePostException e) {
			// XXX This is a hack just to test the flow of error handling.
			if (e.getCode() == 409) {
				return "This snack already exists";
			}
		}
		return null;
	}

	/**
	 * Create the SuggestionViewModel for the view from the given
	 * SnackShopViewModel.
	 * 
	 * @param snackShopInfo
	 * @return a fresh SuggestionViewModel.
	 */
	protected SuggestionsViewModel createSuggestionsModel(SnackShopViewModel snackShopInfo) {
		SuggestionsViewModel ssm = new SuggestionsViewModel();
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			if (sm.getPurchaseCount() == 0) {
				SuggestionViewModel smx = new SuggestionViewModel();
				smx.setName(sm.getName());
				smx.setLocation(sm.getPurchaseLocations());
				ssm.add(smx);
			}
		}
		return ssm;
	}
}