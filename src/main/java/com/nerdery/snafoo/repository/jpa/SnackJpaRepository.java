package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.Snack;
import com.nerdery.snafoo.repository.SnackRepository;

/**
 * JPA Repository for Snack objects.
 * 
 */
@Repository
public interface SnackJpaRepository extends CrudRepository<Snack, Long>, SnackRepository {

}
