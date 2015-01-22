package com.nerdery.snafoo.controllers;

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.TestProject;
import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.model.view.TestCompanyInfo;
import com.nerdery.snafoo.services.TestPageService;
import com.nerdery.snafoo.services.TestProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClientException;

/**
 *
 */
@Controller
public class TestController implements Logging {

    private ConversionService converterService;
    private TestPageService testPageService;
    private TestProjectService testProjectService;

    @RequestMapping("/errorTest")
    public void renderErrorPage() {
        throw new RestClientException("This is a fake RestClientException.");
    }

    @RequestMapping("/")
    public String renderTestPage(Model model) {
        TestFacebookPage domainPage = testPageService.fetchTestPage();
        TestCompanyInfo nerderyInfo = converterService.convert(domainPage, TestCompanyInfo.class);
        Iterable<TestProject> testProjects = testProjectService.fetchTestProjects();
        model.addAttribute("nerderyInfo", nerderyInfo);
        model.addAttribute("projects", testProjects);
        return "index";
    }

    @Autowired
    @Qualifier("customConversionService")
    public void setConverterService(ConversionService converterService) {
        this.converterService = converterService;
    }

    @Autowired
    public void setTestProjectService(TestProjectService testProjectService) {
        this.testProjectService = testProjectService;
    }

    @Autowired
    public void setTestPageService(TestPageService testPageService) {
        this.testPageService = testPageService;
    }
}
