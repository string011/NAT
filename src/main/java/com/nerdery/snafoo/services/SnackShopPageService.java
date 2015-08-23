package com.nerdery.snafoo.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.repository.SnackShopPageRepository;

/**
 * Service providing access to a SnackShopPageRepository. 
 */
@Service
public class SnackShopPageService {

    private SnackShopPageRepository snackShopPageRepository;

    public List<SnackPageModel> fetchSnackShopHomePage() {
        return snackShopPageRepository.getSnackShopHomePage();
    }

    @Inject
    public void setSnackShopPageRepository(SnackShopPageRepository snackShopPageRepository) {
        this.snackShopPageRepository = snackShopPageRepository;
    }
}

