package com.nerdery.snafoo.model.view;

import java.util.List;

/**
 * Example view model object. It can be safely deleted once you have implemented your own model class(es).
 */
public class ExampleCompanyModel {

    private String name;
    private List<String> urls;
    private String description;

    public ExampleCompanyModel(String name, List<String> urls, String description) {
        this.name = name;
        this.urls = urls;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> url) {
        this.urls = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
