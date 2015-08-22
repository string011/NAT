package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel2;
import com.nerdery.snafoo.repository.ExampleProjectRepository2;

/**
 * Barebones repository for TestProject objects utilizing Spring's automatic CrudRepository implementation. It can be safely deleted once
 * you have implemented your own repository(ies).
 */
@Repository
public interface ExampleJpaProjectRepository2 extends CrudRepository<ExampleProjectModel2, Long>, ExampleProjectRepository2 {

}
