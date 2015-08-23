package com.nerdery.snafoo.controllers;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nerdery.snafoo.model.domain.rest.SnackPageModel;
import com.nerdery.snafoo.model.view.SnackShopModel;
import com.nerdery.snafoo.services.SnackShopPageService;

/**
 * Top level entry point for the snack shop.
 * @author string
 *
 */
@Controller
public class SnackShopController {
	
    private ConversionService converterService;
    private SnackShopPageService snackShopPageService;
    // private ExampleProjectService exampleProjectService;

    /*
    @RequestMapping("/errorTest")
    public void renderErrorPage() {
        throw new RestClientException("This is a fake RestClientException.");
    }
    */

    @RequestMapping("/")
    public String renderPage(Model model) {
        List<SnackPageModel> domainPage = snackShopPageService.fetchSnackShopHomePage();
        SnackShopModel snackShopInfo = converterService.convert(domainPage, SnackShopModel.class);
        // Iterable<ExampleProjectModel> testProjects = exampleProjectService.fetchTestProjects();

        model.addAttribute("snackShopInfo", snackShopInfo);
        return "voting";
    }

	public SnackShopPageService getSnackShopPageService() {
		return snackShopPageService;
	}

	@Inject
	public void setSnackShopPageService(SnackShopPageService snackShopPageService) {
		this.snackShopPageService = snackShopPageService;
	}

	
	public ConversionService getConverterService() {
		return converterService;
	}

    @Inject
    @Qualifier("customConversionService")
	public void setConverterService(ConversionService converterService) {
		this.converterService = converterService;
	}
}