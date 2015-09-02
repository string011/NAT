package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.SnackJPAModel;

/**
 * Base interface for Snacks
 */
public interface TodoRepository {
    Iterable<SnackJPAModel> findAll();
    SnackJPAModel save(SnackJPAModel snack);
	SnackJPAModel findSnackByName(String name);
}
