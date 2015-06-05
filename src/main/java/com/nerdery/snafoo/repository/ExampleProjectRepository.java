package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel;

/**
 * Base interface for respositories providing access to TestProject models. It can be safely deleted once you have implemented your
 * own repository(ies).
 */
public interface ExampleProjectRepository {
    Iterable<ExampleProjectModel> findAll();
    ExampleProjectModel save(ExampleProjectModel exampleProjectModel);
}
