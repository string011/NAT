package com.nerdery.snafoo.model.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Domain model object to handle JSON unmarshalled data. 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SnackShopPageModel {

    private String name;
    private String companyOverview;
    private String description;
    private String website;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("company_overview")
    public String getCompanyOverview() {
        return companyOverview;
    }

    public void setCompanyOverview(String companyOverview) {
        this.companyOverview = companyOverview;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}