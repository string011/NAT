package com.nerdery.snafoo.model.view;

import java.util.List;

/**
 *
 */
public class TestCompanyInfo {

    private String name;
    private List<String> urls;
    private String description;

    public TestCompanyInfo(String name, List<String> urls, String description) {
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
