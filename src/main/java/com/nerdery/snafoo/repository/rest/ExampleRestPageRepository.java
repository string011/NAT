package com.nerdery.snafoo.repository.rest;

import com.nerdery.snafoo.model.domain.rest.ExamplePageModel;
import com.nerdery.snafoo.repository.ExamplePageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

/**
 * Repository implementation using Spring's RestTemplate to query a REST endpoint for model data. It can be safely deleted once you have
 * implemented you own repository(ies).
 */
@Repository
public class ExampleRestPageRepository implements ExamplePageRepository {
    private RestTemplate restTemplate;
    private String restUrl;

    @Inject
    public ExampleRestPageRepository(@Value("${test.facebook.restUrl}") String restUrl) {
        restTemplate = new RestTemplate();
        this.restUrl = restUrl;
    }

    @Override
    public ExamplePageModel getTestPage() {
        return restTemplate.getForObject(restUrl, ExamplePageModel.class);
    }
}
