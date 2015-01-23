package com.nerdery.snafoo;

import com.nerdery.snafoo.model.domain.jpa.TestProject;
import com.nerdery.snafoo.repository.TestProjectRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
public class SnackFoodApplication {

    @Bean(name = "customConversionService")
    public ConversionService conversionService(List<Converter> converters)
    {
        DefaultConversionService conversionService = new DefaultConversionService();
        converters.forEach(conversionService::addConverter);
        return conversionService;
    }

    private static void seedDatabase(ConfigurableApplicationContext context) {
        TestProjectRepository repository = (TestProjectRepository) context.getBeanFactory().getBean("jpaTestProjectRepository");
        Assert.notNull(repository, "Failed to seed test database, due to missing repository object.");
        for (int i = 1; i < 4; i++) {
            TestProject project = new TestProject("Test Project #" + i, i * 100, i * 2);
            repository.save(project);
        }
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SnackFoodApplication.class, args);
        seedDatabase(context);
    }
}
