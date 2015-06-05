package com.nerdery.snafoo.repository.jpa;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel;
import com.nerdery.snafoo.repository.ExampleProjectRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Barebones repository for TestProject objects utilizing Spring's automatic CrudRepository implementation. It can be safely deleted once
 * you have implemented your own repository(ies).
 */
@Repository
public interface ExampleJpaProjectRepository extends CrudRepository<ExampleProjectModel, Long>, ExampleProjectRepository {

}
