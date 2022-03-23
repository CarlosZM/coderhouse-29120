package com.coderhouse.nine.base;

public class Product {

    private String name;

    private Brand brand;

    private Double price;

    private Category category;

    private Integer stock;

    private Boolean enabled;

    public Product(String name, Brand brand, Double price, Category category, Integer stock, Boolean enabled) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
