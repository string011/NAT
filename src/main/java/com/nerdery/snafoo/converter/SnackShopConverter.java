package com.nerdery.snafoo.converter;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackModel;
import com.nerdery.snafoo.model.view.SnackShopModel;

/**
 * An example Spring Converter which converts from a domain model (TestFacebookPage) to a view model
 * (TestCompanyInfo). It can be safely deleted once you have implemented your own converter(s).
 */
@Component
public class SnackShopConverter implements Converter<List<SnackPageModel>, SnackShopModel> {

    @Override
    public SnackShopModel convert(List<SnackPageModel> source) {
	    SnackShopModel ssm = new SnackShopModel();
    	for (SnackPageModel snack : source){
    		SnackModel sm = new SnackModel();
    		sm.setId(snack.getId());
    		ssm.add(sm);
    		
    	}
    	/*
        String combinedDescription = source.getDescription() + " " + source.getCompanyOverview();
        List<String> urls = Arrays.asList(source.getWebsite().split("\\s+"))
                .stream()
                .map(url -> "http://" + url)
                .collect(Collectors.toList());
                */
        return ssm;
    }
}
