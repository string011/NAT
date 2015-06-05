package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.rest.ExamplePageModel;

/**
 * Base interface for respositories providing access to TestFacebookPage models. It can be safely deleted once you have implemented your
 * own repository(ies).
 */
public interface ExamplePageRepository {
    ExamplePageModel getTestPage();
}
