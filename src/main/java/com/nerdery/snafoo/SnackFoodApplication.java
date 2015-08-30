package com.nerdery.snafoo;

import java.util.List;

import org.slf4j.LoggerFactory;
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

import com.nerdery.snafoo.common.Logging;
import com.nerdery.snafoo.model.domain.jpa.Todo;
import com.nerdery.snafoo.model.domain.jpa.SnackShopJPAModel;
import com.nerdery.snafoo.repository.TodoRepository;
import com.nerdery.snafoo.repository.SnackShopRepository;

/**
 * Configuration object for the application's root context.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SnackFoodApplication implements EmbeddedServletContainerCustomizer, Logging {

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
        SnackShopRepository snackShopRepository = (SnackShopRepository) context.getBeanFactory().getBean("snackShopJpaRepository");
        Assert.notNull(snackShopRepository, "Failed to seed test database, due to missing snackShop object.");
        TodoRepository  snackRepository = (TodoRepository) context.getBeanFactory().getBean("snackJpaRepository");
        Assert.notNull(snackRepository, "Failed to seed test database, due to missing repository object.");
        /*
        for (int i = 1; i < 4; i++) {
            snackShopRepository.save(new SnackShopJPAModel("SnackShopJPAModel " + i, i * 100, i * 2));
        }
        Iterable<SnackShopJPAModel>snackShops = snackShopRepository.findAll();
        for (SnackShopJPAModel snackShop : snackShops) {
        	List<SnackJPAModel> snacks = snackShop.getSnacks();
        	for (SnackJPAModel snack : snacks){
        		LoggerFactory.getLogger(SnackFoodApplication.class).debug(snack.getName());
        	}
		}
		*/
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SnackFoodApplication.class, args);
        seedDatabase(context);
    }
}
