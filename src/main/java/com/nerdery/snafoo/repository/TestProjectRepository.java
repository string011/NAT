package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.TestProject;

/**
 *
 */
public interface TestProjectRepository {

    Iterable<TestProject> findAll();
    TestProject save(TestProject testProject);
}
