package com.nerdery.snafoo.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nerdery.snafoo.model.domain.jpa.SnackShop;
import com.nerdery.snafoo.repository.SnackShopRepository;

/**
 * Barebones repository for TestProject objects utilizing Spring's automatic CrudRepository implementation. It can be safely deleted once
 * you have implemented your own repository(ies).
 */
@Repository
public interface SnackShopJpaRepository extends CrudRepository<SnackShop, Long>, SnackShopRepository {

}
