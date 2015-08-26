package com.nerdery.snafoo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackModel;
import com.nerdery.snafoo.model.view.SnackShopModel;

/**
 * Top level entry point for the snack shop. Handles control of the 'main' page
 * and vote submissions.
 * 
 * @author string
 *
 */
@Controller
public class SnackShopController extends AbstractSnackShopController {

	// This is my faked data storage for voted snacks.
	// This really should persist to a DB or web service.
	private Map<String, SnackModel> voted = new HashMap<String, SnackModel>();

	/*
	 * @RequestMapping("/errorTest") public void renderErrorPage() { throw new
	 * RestClientException("This is a fake RestClientException."); }
	 */

	@RequestMapping("/")
	public String renderPage(Model model) {
		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopModel snackShopInfo = convert(domainPage);
		for (SnackModel sm : snackShopInfo.getSnacks()) {
			if (voted.containsKey(sm.getName())) {
				sm.setVoteCount(voted.get(sm.getName()).getVoteCount());
			}
		}
		model.addAttribute("snackShopInfo", snackShopInfo);
		return "voting";
	}

	/**
	 * Handle the case when a user votes for a snack. This is quick and dirty,
	 * but I didn't know how to deal with the button selection in a dynamic
	 * table via form submission.
	 * 
	 * @param postPayload
	 * @return the redirect location;
	 */
	@RequestMapping(value = "/voted", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public String handleSnackVote(@RequestBody String postPayload) {
		String[] kv = postPayload.split("=");
		@SuppressWarnings("unused")
		String key = kv[0];
		String value = kv[1];

		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopModel snackShopInfo = convert(domainPage);
		for (SnackModel sm : snackShopInfo.getSnacks()) {
			if (value.equals(sm.getName())) {
				if (!voted.containsKey(sm.getName())) {
					voted.put(sm.getName(), sm);
				} else {
					sm = voted.get(sm.getName());
				}
				sm.incrementVoteCount();

				try {
					Snack snack = findSnackByName(sm.getName());
					snack.incrementVoteCount();
					save(snack);
				} catch (SnackNotFoundException e) {
					getLogger().error("Unhandled snack not found: " + sm.getName(), e);
				}

			}
		}
		return "redirect:/";
	}
}