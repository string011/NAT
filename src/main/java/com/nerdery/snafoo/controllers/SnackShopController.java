package com.nerdery.snafoo.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
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
		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopViewModel snackShopInfo = convert(domainPage);
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			SnackJPAModel snack = null;
			try {
				snack = findSnackByName(sm.getName());
			} catch (SnackNotFoundException e) {
				if (sm.isOptional()) {
					snack = createSnack(sm.getName());
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
	@RequestMapping(value = "/voted", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
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

		List<SnackPageModel> domainPage = getRESTDomainPage();
		SnackShopViewModel snackShopInfo = convert(domainPage);
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
	 @RequestMapping(value="votetest", method = RequestMethod.POST)
	  public @ResponseBody Person post( @RequestBody final  Person person) {    
	 
	      System.out.println(person.getId() + " " + person.getName());
	      return person;
	  }
}