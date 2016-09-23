package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aw on 23.09.16.
 */
public class Product implements Serializable {
    long productId;
    String description;
    double price = 0;
    int numberAvailable = 100;
    int numberOrdered = 0;

    public Product() {
    }

    public Product(long productId, String description, double price, int numberAvailable, int numberOrdered) {
        this.productId = productId;
        this.description = description;
        this.price = price;
        this.numberAvailable = numberAvailable;
        this.numberOrdered = numberOrdered;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public int getNumberOrdered() {
        return numberOrdered;
    }

    public void setNumberOrdered(int numberOrdered) {
        this.numberOrdered = numberOrdered;
    }
}
