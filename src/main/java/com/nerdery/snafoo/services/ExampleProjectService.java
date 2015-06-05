package com.nerdery.snafoo.services;

import com.nerdery.snafoo.model.domain.jpa.ExampleProjectModel;
import com.nerdery.snafoo.repository.ExampleProjectRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Example service providing access to a TestProjectRepository. It can be safely deleted once you have implemented your own service(s).
 */
@Service
public class ExampleProjectService {

    private ExampleProjectRepository exampleProjectRepository;

    public Iterable<ExampleProjectModel> fetchTestProjects() {
        return exampleProjectRepository.findAll();
    }

    @Inject
    public void setExampleProjectRepository(ExampleProjectRepository exampleProjectRepository) {
        this.exampleProjectRepository = exampleProjectRepository;
    }
}
