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

/**
 * Controller for the "suggestions" page. Might be a good idea to make an
 * abstract base class for controllers to avoid duplicate code.
 * 
 * @author string
 *
 */
@Controller
public class SuggestionsController extends AbstractSnackShopController {
	// Hack to simulate persistence.
	private Map<String, SuggestionModel> savedSuggestions = new HashMap<String, SuggestionModel>();

	@RequestMapping(value = "/suggestions", method = RequestMethod.GET)
	public String renderPage(Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopModel snackShopInfo = convert(domainPage);

		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
		model.addAttribute("xerror", new ErrorModel("An error message"));
		return "suggestions";
	}

	@RequestMapping(value = "/suggestion", method = RequestMethod.POST)
	public String handleSuggestion(@ModelAttribute SuggestionsModel suggestions, Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		if (suggestions.getName() != null && suggestions.getLocation() != null && suggestions.getName().length() != 0) {
			SuggestionModel sug = new SuggestionModel();
			sug.setName(suggestions.getName());
			sug.setLocation(suggestions.getLocation());
			// post the suggestion to the REST endpoint, and to the local JPA
			// repo
			postSuggestionToWebService(sug);
			// savedSuggestions.put(sug.getName(), sug);
			// find the matching snack from local DB and update if it exists.
			// if it doesn't exist, put it in the local db.
			try {
				Snack snack = findSnackByName(sug.getName());
			} catch (SnackNotFoundException e) {
				Snack snack = new Snack();
				snack.setName(sug.getName());
				snack.setSuggestionDate(new Date());
				snackRepository.save(snack);
			}
		}
		SnackShopModel snackShopInfo = convert(domainPage);
		SuggestionsModel ssm = createSuggestionsModel(snackShopInfo);
		model.addAttribute("suggestions", ssm);
		return "suggestions";
	}

	private void postSuggestionToWebService(SuggestionModel sug) {
		Snack snack = new Snack();
		snack.setName(sug.getName());
		snack.setLocation(sug.getLocation());
		getSnackShopPageService().addSuggestion(snack);
		
	}

	public Snack findSnackByName(String name) throws SnackNotFoundException {
		Iterable<Snack> snacks = snackRepository.findAll();
		for (Snack s : snacks) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		throw new SnackNotFoundException(name);
	}

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
		for (SuggestionModel sm : savedSuggestions.values()) {
			ssm.add(sm);
		}
		return ssm;
	}
}