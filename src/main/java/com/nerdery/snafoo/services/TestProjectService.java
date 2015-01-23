package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.jpa.TestProject;
import com.nerdery.snafoo.repository.TestProjectRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Example service providing access to a TestProjectRepository.
 */
@Service
public class TestProjectService {

    private TestProjectRepository testProjectRepository;

    public Iterable<TestProject> fetchTestProjects() {
        return testProjectRepository.findAll();
    }

    @Inject
    public void setTestProjectRepository(TestProjectRepository testProjectRepository) {
        this.testProjectRepository = testProjectRepository;
    }
}
