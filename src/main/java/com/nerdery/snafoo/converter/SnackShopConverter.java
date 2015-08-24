package com.nerdery.snafoo.converter;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackModel;
import com.nerdery.snafoo.model.view.SnackShopModel;

/**
 * A Spring Converter which converts from a domain model List<SnackShopModel>
 * view model (SnackShopModel). 
 */
@Component
public class SnackShopConverter implements Converter<List<SnackPageModel>, SnackShopModel> {

	@Override
	public SnackShopModel convert(List<SnackPageModel> source) {
		SnackShopModel ssm = new SnackShopModel();
		for (SnackPageModel snack : source) {
			SnackModel sm = new SnackModel();
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
