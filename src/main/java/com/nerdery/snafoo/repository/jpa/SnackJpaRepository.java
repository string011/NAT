package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.Todo;
import com.nerdery.snafoo.repository.TodoRepository;

/**
 * JPA Repository for SnackJPAModel objects.
 * 
 */
@Repository
public interface SnackJpaRepository extends CrudRepository<Todo, Long>, TodoRepository {

}
