package com.nerdery.snafoo;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel;
import com.nerdery.snafoo.repository.ExampleProjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.MimeMappings;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Configuration object for the application's root context.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SnackFoodApplication implements EmbeddedServletContainerCustomizer {

    /**
     * Register any Spring-managed converters with a default conversion service, which will be made available for injection into other
     * classes.
     *
     * @param converters A List of all known Converter objects
     * @return A conversion service with the given converters registered
     */
    @Bean(name = "customConversionService")
    public ConversionService conversionService(List<Converter> converters) {
        DefaultConversionService conversionService = new DefaultConversionService();
        converters.forEach(conversionService::addConverter);
        return conversionService;
    }

    /**
     * Add support for serving JSON data with the proper MIME type to the servlet container. This is used for fixture demo data and can be
     * safely removed if you won't be using any JSON fixture data in your NAT submission.
     *
     * @param container The embedded Spring Boot Servlet container
     */
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        MimeMappings mappings = new MimeMappings(MimeMappings.DEFAULT);
        mappings.add("json","application/json");
        container.setMimeMappings(mappings);
    }

    /**
     * See the database with example data. This method can be re-purposed or deleted when you create your snack food implementation.
     *
     * @param context The main application context, which will be used to fetch configured beans.
     */
    private static void seedDatabase(ConfigurableApplicationContext context) {
        ExampleProjectRepository repository = (ExampleProjectRepository) context.getBeanFactory().getBean("exampleJpaProjectRepository");
        Assert.notNull(repository, "Failed to seed test database, due to missing repository object.");
        for (int i = 1; i < 4; i++) {
            repository.save(new ExampleProjectModel("Example Project #" + i, i * 100, i * 2));
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SnackFoodApplication.class, args);
        seedDatabase(context);
    }
}
