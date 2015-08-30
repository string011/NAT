package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.Todo;

/**
 * Base interface for Snacks
 */
public interface TodoRepository {
    Iterable<Todo> findAll();
    Todo save(Todo snack);
	Todo findSnackByName(String name);
}
