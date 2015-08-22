package com.nerdery.snafoo.repository;

import com.nerdery.snafoo.model.domain.jpa.SnackShop;

/**
 * Base interface for SnackShop
 */
public interface SnackShopRepository {
    Iterable<SnackShop> findAll();
    SnackShop save(SnackShop snackShop);
}
