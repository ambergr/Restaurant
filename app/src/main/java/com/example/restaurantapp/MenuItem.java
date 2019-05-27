package com.example.restaurantapp;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name;
    private String description;
    private String imageUrl;
    private float price;
    private String category;

    public MenuItem(String name, String description, String imageUrl, float price, String category){
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price= price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
