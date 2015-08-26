package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.SnackShopJPAModel;
import com.nerdery.snafoo.repository.SnackShopRepository;

/**
 * JPA Repository for SnackShopJPAModel objects.
 * 
 */
@Repository
public interface SnackShopJpaRepository extends CrudRepository<SnackShopJPAModel, Long>, SnackShopRepository {

}
