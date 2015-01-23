package com.nerdery.snafoo.converter;

import com.nerdery.snafoo.model.domain.rest.TestFacebookPage;
import com.nerdery.snafoo.model.view.TestCompanyInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An example Spring Converter which converts from a domain model (TestFacebookPage) to a view model
 * (TestCompanyInfo).
 */
@Component
public class TestFacebookCompanyConverter implements Converter<TestFacebookPage, TestCompanyInfo> {

    @Override
    public TestCompanyInfo convert(TestFacebookPage source) {
        String combinedDescription = source.getDescription() + " " + source.getCompanyOverview();
        List<String> urls = Arrays.asList(source.getWebsite().split("\\s+"))
                .stream()
                .map(url -> "http://" + url)
                .collect(Collectors.toList());
        return new TestCompanyInfo(source.getName(), urls, combinedDescription);
    }
}
