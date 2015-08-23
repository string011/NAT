package com.nerdery.snafoo.controllers;

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel;
import com.nerdery.snafoo.model.domain.rest.ExamplePageModel;
import com.nerdery.snafoo.model.view.ExampleCompanyModel;
import com.nerdery.snafoo.services.ExamplePageService;
import com.nerdery.snafoo.services.ExampleProjectService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

import javax.inject.Inject;

/**
 * Example MVC controller demonstrating injection and consumption of various services, request handler methods, and
 * a forced exception for testing the exception handling logic. It can be safely deleted once you have implemented your
 * own controller(s).
 */
@Controller
public class ExampleController implements Logging {

    private ConversionService converterService;
    private ExamplePageService examplePageService;
    private ExampleProjectService exampleProjectService;

    @RequestMapping("/errorTest")
    public void renderErrorPage() {
        throw new RestClientException("This is a fake RestClientException.");
    }

    @RequestMapping("/test")
    public String renderTestPage(Model model) {
        ExamplePageModel domainPage = examplePageService.fetchTestPage();
        ExampleCompanyModel nerderyInfo = converterService.convert(domainPage, ExampleCompanyModel.class);
        Iterable<ExampleProjectModel> testProjects = exampleProjectService.fetchTestProjects();

        model.addAttribute("nerderyInfo", nerderyInfo);
        model.addAttribute("projects", testProjects);

        return "index";
    }

    @Inject
    @Qualifier("customConversionService")
    public void setConverterService(ConversionService converterService) {
        this.converterService = converterService;
    }

    @Inject
    public void setExampleProjectService(ExampleProjectService exampleProjectService) {
        this.exampleProjectService = exampleProjectService;
    }

    @Inject
    public void setExamplePageService(ExamplePageService examplePageService) {
        this.examplePageService = examplePageService;
    }
}
