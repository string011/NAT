package com.nerdery.snafoo.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;
import com.nerdery.snafoo.model.view.SnackShopViewModel;
import com.nerdery.snafoo.model.view.SnackViewModel;

/**
 * Top level entry point for the snack shop. Handles control of the 'main' page
 * and vote submissions.
 * 
 * @author string
 *
 */
@Controller
public class SnackShopController extends AbstractSnackShopController {

	/*
	 * @RequestMapping("/errorTest") public void renderErrorPage() { throw new
	 * RestClientException("This is a fake RestClientException."); }
	 */

	@RequestMapping("/")
	public String renderPage(Model model) {
		SnackShopViewModel snackShopInfo = getSnackShopViewModel();
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			SnackJPAModel snack = null;
			try {
				snack = findSnackByName(sm.getName());
			} catch (SnackNotFoundException e) {
				if (sm.isOptional()) {
					snack = createSnack(sm.getName(), sm.getId());
				}
			}
			if (snack != null) {
				sm.setVoteCount(snack.getVoteCount());
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
	@RequestMapping(value = "/votedOld", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public RedirectView handleSnackVote(@RequestBody String postPayload) {
		String[] kv = postPayload.split("=");
		@SuppressWarnings("unused")
		String key = kv[0];
		String value = null;
		try {
			value = URLDecoder.decode(kv[1], "UTF8");
		} catch (UnsupportedEncodingException e1) {
			getLogger().error("", e1);
		}

		SnackShopViewModel snackShopInfo = getSnackShopViewModel();
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			if (value.equals(sm.getName())) {
				if (sm.isOptional() && !sm.isPurchased()) {
					sm.incrementVoteCount();
					try {
						SnackJPAModel snack = findSnackByName(sm.getName());
						snack.incrementVoteCount();
						save(snack);
					} catch (SnackNotFoundException e) {
						getLogger().info("snack not found creating new DB entry: " + sm.getName());
						SnackJPAModel snack = new SnackJPAModel();
						snack.setName(sm.getName());
						snack.incrementVoteCount();
						snack.setId(sm.getId());
						snack.setLocation(sm.getPurchaseLocations());
						save(snack);
					}
				}
			}
		}
		return safeRedirect("/");
	}

	public RedirectView safeRedirect(String url) {
		RedirectView rv = new RedirectView(url);
		rv.setExposeModelAttributes(false);
		rv.setContextRelative(true);
		return rv;
	}

	@RequestMapping(value = "/voted", method = RequestMethod.POST)
	public @ResponseBody SnackViewModelVotingData post(@RequestBody final SnackViewModelVotingData voteCount) {
		SnackShopViewModel snackShopInfo = getSnackShopViewModel();
		SnackJPAModel snack = null;
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			if (voteCount.getId().equals(String.valueOf(sm.getId()))) {
				if (sm.isOptional() && !sm.isPurchased()) {
					sm.incrementVoteCount();
					try {
						snack = findSnackByRemoteId(sm.getId());
						snack.incrementVoteCount();
						save(snack);
					} catch (SnackNotFoundException e) {
						getLogger().info("snack not found creating new DB entry: " + sm.getName());
						snack = new SnackJPAModel();
						snack.setName(sm.getName());
						snack.incrementVoteCount();
						snack.setId(sm.getId());
						snack.setLocation(sm.getPurchaseLocations());
						save(snack);
					}
				}
			}
		}
		voteCount.setVoteCount(String.valueOf(snack.getVoteCount()));
		return voteCount;
	}
}