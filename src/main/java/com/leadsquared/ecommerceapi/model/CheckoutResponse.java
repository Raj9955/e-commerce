package com.leadsquared.ecommerceapi.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutResponse {

    private String created;

    //create a different class instead of product to get product price with all texes
    private List<Product> products = new ArrayList<>();

    private double discount;

    private int totalPrice;

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
