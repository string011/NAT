package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.jpa.TestProject;
import com.nerdery.snafoo.repository.TestProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class TestProjectService {

    private TestProjectRepository testProjectRepository;

    public Iterable<TestProject> fetchTestProjects() {
        return testProjectRepository.findAll();
    }

    @Autowired
    public void setTestProjectRepository(TestProjectRepository testProjectRepository) {
        this.testProjectRepository = testProjectRepository;
    }
}
