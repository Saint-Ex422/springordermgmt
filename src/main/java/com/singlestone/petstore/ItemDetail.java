package com.singlestone.petstore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * used for retrieving data from azure rest api
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemDetail {

    @JsonProperty(value="Id")
    private String id;
    @JsonProperty(value="Name")
    private String name;
    @JsonProperty(value="Price")
    private double price;
    @JsonProperty(value="Message")
    private String category;

    public ItemDetail(){}

    public ItemDetail(String id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
