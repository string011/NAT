package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.Snack;

/**
 * Base interface for Snacks
 */
public interface SnackRepository {
    Iterable<Snack> findAll();
    Snack save(Snack snack);
	Snack findSnackByName(String name);
}
