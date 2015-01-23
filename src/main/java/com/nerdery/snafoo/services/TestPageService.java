package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.repository.TestPageRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Example service providing access to a TestPageRepository.
 */
@Service
public class TestPageService {

    private TestPageRepository testPageRepository;

    public TestFacebookPage fetchTestPage() {
        return testPageRepository.getTestPage();
    }

    @Inject
    public void setTestPageRepository(TestPageRepository testPageRepository) {
        this.testPageRepository = testPageRepository;
    }
}

