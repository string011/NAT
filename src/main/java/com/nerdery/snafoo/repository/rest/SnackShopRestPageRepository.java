package com.nerdery.snafoo.repository.rest;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nerdery.snafoo.model.domain.rest.SnackShopPageModel;
import com.nerdery.snafoo.repository.SnackShopPageRepository;

/**
 * Repository implementation using Spring's RestTemplate to query a REST endpoint for model data. It can be safely deleted once you have
 * implemented you own repository(ies).
 */
@Repository
public class SnackShopRestPageRepository implements SnackShopPageRepository {
    private RestTemplate restTemplate;
    private String restUrl;

    @Inject
    public SnackShopRestPageRepository(@Value("${test.facebook.restUrl}") String restUrl) {
        restTemplate = new RestTemplate();
        this.restUrl = restUrl;
    }

	@Override
	public SnackShopPageModel getSnackShopHomePage() {
        return restTemplate.getForObject(restUrl, SnackShopPageModel.class);
	}
}
