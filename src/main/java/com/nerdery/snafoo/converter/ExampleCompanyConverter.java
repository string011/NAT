package com.nerdery.snafoo.converter;

import com.nerdery.snafoo.model.domain.rest.ExamplePageModel;
import com.nerdery.snafoo.model.view.ExampleCompanyModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * An example Spring Converter which converts from a domain model (TestFacebookPage) to a view model
 * (TestCompanyInfo). It can be safely deleted once you have implemented your own converter(s).
 */
@Component
public class ExampleCompanyConverter implements Converter<ExamplePageModel, ExampleCompanyModel> {

    @Override
    public ExampleCompanyModel convert(ExamplePageModel source) {
        String combinedDescription = source.getDescription() + " " + source.getCompanyOverview();
        List<String> urls = Arrays.asList(source.getWebsite().split("\\s+"))
                .stream()
                .map(url -> "http://" + url)
                .collect(Collectors.toList());
        return new ExampleCompanyModel(source.getName(), urls, combinedDescription);
    }
}
