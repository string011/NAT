package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.repository.TestPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void setTestPageRepository(TestPageRepository testPageRepository) {
        this.testPageRepository = testPageRepository;
    }
}

