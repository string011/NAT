package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.repository.TestPageRepository;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
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

