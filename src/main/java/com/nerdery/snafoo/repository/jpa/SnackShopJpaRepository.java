package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.SnackShop;
import com.nerdery.snafoo.repository.SnackShopRepository;

/**
 * JPA Repository for SnackShop objects.
 * 
 */
@Repository
public interface SnackShopJpaRepository extends CrudRepository<SnackShop, Long>, SnackShopRepository {

}
