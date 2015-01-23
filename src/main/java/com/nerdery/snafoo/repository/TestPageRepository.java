package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;

/**
 * Base interface for respositories providing access to TestFacebookPage models.
 */
public interface TestPageRepository {
    TestFacebookPage getTestPage();
}
