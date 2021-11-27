package com.leadsquared.ecommerceapi.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CART")
public class Cart {
    @Id
    @Column(name = "PRODUCT_ID")
    protected Integer id;
    @Column(name = "PRODUCT_NAME")
    private String Name;
    @Column(name = "DESCRIPTION")
    private String Description;
    @Column(name = "PRICE")
    private double price;
    @Column(name = "TYPE")
    private String type;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
