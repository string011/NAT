package com.nerdery.snafoo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nerdery.snafoo.model.domain.jpa.Todo;
import com.nerdery.snafoo.model.view.SnackShopViewModel;
import com.nerdery.snafoo.model.view.SnackViewModel;

/**
 * Controller for the "shoppingList" page.
 * 
 * @author string
 *
 */
@Controller
public class ShoppingListController extends AbstractSnackShopController {

	@RequestMapping("/shoppinglist")
	public String renderPage(Model model) {
		SnackShopViewModel snackShopInfo = getSnackShopViewModel();
		for (SnackViewModel sm : snackShopInfo.getSnacks()) {
			Todo snack = null;
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
		List<SnackViewModel> sortedSnacks = snackShopInfo.getNonOptionalSnacks();
		sortedSnacks = new ArrayList<SnackViewModel>(sortSnacks(sortedSnacks));
		List<SnackViewModel> optional = snackShopInfo.getOptionalSnacks();
		optional = new ArrayList<SnackViewModel>(sortSnacks(optional).descendingSet());
		sortedSnacks.addAll(optional);
		snackShopInfo.setSnacks(sortedSnacks);
		model.addAttribute("snackShopInfo", snackShopInfo);
		return "shoppingList";
	}

	private NavigableSet<SnackViewModel> sortSnacks(List<SnackViewModel> snacks) {
		NavigableSet<SnackViewModel> ss = new TreeSet<SnackViewModel>(new ByVoteCountComparator<SnackViewModel>());
		ss.addAll(snacks);
		return ss;
	}
}