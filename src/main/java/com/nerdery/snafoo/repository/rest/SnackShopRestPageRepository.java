package com.nerdery.snafoo.repository.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.domain.rest.SuggestionPageModel;
import com.nerdery.snafoo.repository.SnackShopPageRepository;

/**
 * Repository implementation using Spring's RestTemplate to query a REST
 * endpoint for Snack model data.
 */
@Repository
public class SnackShopRestPageRepository implements SnackShopPageRepository, Logging {
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

	/**
	 * Attempt to post a snack suggestion to the web service.
	 */
	@Override
	public Snack addSuggestion(Snack snack) {
		URI url;
		try {
			RestTemplate rt = new RestTemplate();
			url = new URI("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
			SuggestionPageModel spm = new SuggestionPageModel();
			// spm.setName(snack.getName());
			// spm.setLocation(snack.getLocation());
			ResponseEntity<SuggestionPageModel> response = rt.postForEntity(url, spm, SuggestionPageModel.class);
			HttpStatus status = response.getStatusCode();
		} catch (HttpClientErrorException e) {
			getLogger().error("unhandled client exception: " + e.getStatusText(), e);
		} catch (URISyntaxException e) {
			getLogger().error("unhandled exception: ", e);
		}
		return snack;
	}
}
