package com.nerdery.snafoo.repository.jpa;

import com.nerdery.snafoo.model.domain.jpa.TestProject;
import com.nerdery.snafoo.repository.TestProjectRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Barebones repository for TestProject objects utilizing Spring's automatic CrudRepository implementation.
 */
@Repository
public interface JpaTestProjectRepository extends CrudRepository<TestProject, Long>, TestProjectRepository {

}
