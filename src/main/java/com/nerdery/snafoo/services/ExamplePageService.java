package com.nerdery.snafoo.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nerdery.snafoo.model.domain.rest.ExamplePageModel;
import com.nerdery.snafoo.repository.ExamplePageRepository;

/**
 * Example service providing access to a TestPageRepository. It can be safely deleted once you have implemented your own service(s).
 */
@Service
public class ExamplePageService {

    private ExamplePageRepository examplePageRepository;

    public ExamplePageModel fetchTestPage() {
        return examplePageRepository.getTestPage();
    }

    @Inject
    public void setExamplePageRepository(ExamplePageRepository examplePageRepository) {
        this.examplePageRepository = examplePageRepository;
    }
}

