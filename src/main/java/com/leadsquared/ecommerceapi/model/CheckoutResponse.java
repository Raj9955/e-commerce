package com.leadsquared.ecommerceapi.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutResponse {

    private String billDate;

    //create a different class instead of product to get product price with all texes
    private List<Product> products = new ArrayList<>();

    private double discount;

    private double totalPrice;

    private double payableAmount;

    public double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
