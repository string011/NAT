package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.TestProject;

/**
 * Base interface for respositories providing access to TestProject models.
 */
public interface TestProjectRepository {
    Iterable<TestProject> findAll();
    TestProject save(TestProject testProject);
}
