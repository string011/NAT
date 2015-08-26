package com.nerdery.snafoo.converter;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackViewModel;
import com.nerdery.snafoo.model.view.SnackShopViewModel;

/**
 * A Spring Converter which converts from a domain model List<SnackShopViewModel>
 * view model (SnackShopViewModel). 
 */
@Component
public class SnackShopConverter implements Converter<List<SnackPageModel>, SnackShopViewModel> {

	@Override
	public SnackShopViewModel convert(List<SnackPageModel> source) {
		SnackShopViewModel ssm = new SnackShopViewModel();
		for (SnackPageModel snack : source) {
			SnackViewModel sm = new SnackViewModel();
			sm.setId(snack.getId());
			sm.setName(snack.getName());
			sm.setOptional(snack.getOptional());
			sm.setPurchaseLocations(snack.getPurchaseLocations());
			if (snack.getPurchaseCount() != null && snack.getPurchaseCount() != 0) {
				sm.setPurchaseCount(snack.getPurchaseCount());
				if (snack.getLastPurchaseDate() != null) {
					sm.setLastPurchaseDate(snack.getLastPurchaseDate());
				}
			}
			ssm.add(sm);
		}
		return ssm;
	}
}
