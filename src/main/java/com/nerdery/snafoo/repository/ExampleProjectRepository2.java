package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel2;

/**
 * Base interface for respositories providing access to TestProject models. It can be safely deleted once you have implemented your
 * own repository(ies).
 */
public interface ExampleProjectRepository2 {
    Iterable<ExampleProjectModel2> findAll();
    ExampleProjectModel2 save(ExampleProjectModel2 exampleProjectModel2);
}
