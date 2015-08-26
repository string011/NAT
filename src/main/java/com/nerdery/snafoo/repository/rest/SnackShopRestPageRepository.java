package com.nerdery.snafoo.repository.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;
import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.domain.rest.SuggestionRESTModel;
import com.nerdery.snafoo.repository.SnackShopPageRepository;
import com.nerdery.snafoo.services.WebServicePostException;

/**
 * Repository implementation using Spring's RestTemplate to query a REST
 * endpoint for SnackJPAModel model data.
 */
@Repository
public class SnackShopRestPageRepository implements SnackShopPageRepository, Logging, ResponseErrorHandler {
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
	public SnackJPAModel addSuggestion(SnackJPAModel snack) throws WebServicePostException {
		URI url;
		try {
			RestTemplate rt = new RestTemplate();
			rt.setErrorHandler(this);
			url = new URI("https://api-snacks.nerderylabs.com/v1/snacks?ApiKey=0eaeec59-fa32-420c-9cc4-e6b96633e211");
			SuggestionRESTModel spm = new SuggestionRESTModel();
			// spm.setName(snack.getName());
			// spm.setLocation(snack.getLocation());
			ResponseEntity<SuggestionRESTModel> response = rt.postForEntity(url, spm, SuggestionRESTModel.class);
			HttpStatus status = response.getStatusCode();
			if (!status.is2xxSuccessful()) {
				int code = status.value();
				String reason = status.getReasonPhrase();
				throw new WebServicePostException(code, reason);
			}
		} catch (URISyntaxException e) {
			getLogger().error("unhandled exception: ", e);
		}
		return snack;
	}

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus s = response.getStatusCode();
		boolean b = !response.getStatusCode().is2xxSuccessful();
		return b;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		getLogger().debug(response.getStatusText());
		response.toString();
	}
}
