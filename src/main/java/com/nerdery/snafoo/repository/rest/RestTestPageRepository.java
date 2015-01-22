package com.nerdery.snafoo.repository.rest;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.repository.TestPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Repository
public class RestTestPageRepository implements TestPageRepository {
    private RestTemplate restTemplate;
    private String restUrl;

    @Autowired
    public RestTestPageRepository(@Value("${test.facebook.restUrl}") String restUrl) {
        restTemplate = new RestTemplate();
        this.restUrl = restUrl;
    }

    @Override
    public TestFacebookPage getTestPage() {
        return restTemplate.getForObject(restUrl, TestFacebookPage.class);
    }
}
