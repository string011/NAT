package com.nerdery.snafoo.repository.rest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.domain.rest.SuggestionPageModel;
import com.nerdery.snafoo.repository.SnackShopPageRepository;

/**
 * Repository implementation using Spring's RestTemplate to query a REST
 * endpoint for Snack model data.
 */
@Repository
public class SnackShopRestPageRepository implements SnackShopPageRepository {
	private String restUri;

	@Inject
	public SnackShopRestPageRepository(@Value("${snack.shop.restUrl}") String restUrl) {
		this.restUri = restUrl;
	}

	@Override
	public List<SnackPageModel> getSnackShopHomePage() {
		SnackPageModel[] snacks = new RestTemplate().getForObject(restUri, SnackPageModel[].class);
		List<SnackPageModel> list = Arrays.asList(snacks);
		return list;
	}

	@Override
	public void addSuggestion(Snack snack) {
		RestTemplate rt = new RestTemplate();
		// uri = new
		// URI("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
		SuggestionPageModel m = new SuggestionPageModel();
		m.setLocation(snack.getLocation());
		m.setName(snack.getName());
		URI ret = rt.postForLocation(restUri, new SuggestionPageModel());
		// XXX need error checking 
	}
}
