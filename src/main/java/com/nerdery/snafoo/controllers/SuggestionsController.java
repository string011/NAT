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

import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.ErrorModel;
import com.nerdery.snafoo.model.view.SnackModel;
import com.nerdery.snafoo.model.view.SnackShopModel;
import com.nerdery.snafoo.model.view.SuggestionModel;
import com.nerdery.snafoo.model.view.SuggestionsModel;
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
		SnackShopModel snackShopInfo = convert(domainPage);

		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
		return "suggestions";
	}

	@RequestMapping(value = "/suggestion", method = RequestMethod.POST)
	public String handleSuggestion(@ModelAttribute SuggestionsModel suggestions, Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		String error = null;
		if (suggestions.getName() != null && suggestions.getLocation() != null && suggestions.getName().length() != 0) {
			SuggestionModel sug = new SuggestionModel();
			sug.setName(suggestions.getName());
			sug.setLocation(suggestions.getLocation());
			// post the suggestion to the REST endpoint, and to the local JPA
			// repo
			error = postSuggestionToWebService(sug);
			// savedSuggestions.put(sug.getName(), sug);
			// find the matching snack from local DB and update if it exists.
			// if it doesn't exist, put it in the local db.
			if (error == null) {
				try {
					Snack snack = findSnackByName(sug.getName());
				} catch (SnackNotFoundException e) {
					Snack snack = new Snack();
					snack.setName(sug.getName());
					snack.setSuggestionDate(new Date());
					snackRepository.save(snack);
				}
			}
		} else {
			error = "Name and location are required";
		}
		SnackShopModel snackShopInfo = convert(domainPage);
		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
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
	private String postSuggestionToWebService(SuggestionModel sug) {
		Snack snack = new Snack();
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
	 * Create the SuggestionModel for the view from the given SnackShopModel.
	 * @param snackShopInfo
	 * @return a fresh SuggestionModel.
	 */
	protected SuggestionsModel createSuggestionsModel(SnackShopModel snackShopInfo) {
		SuggestionsModel ssm = new SuggestionsModel();
		for (SnackModel sm : snackShopInfo.getSnacks()) {
			if (sm.getPurchaseCount() == 0) {
				SuggestionModel smx = new SuggestionModel();
				smx.setName(sm.getName());
				smx.setLocation(sm.getPurchaseLocations());
				ssm.add(smx);
			}
		}
		return ssm;
	}
}