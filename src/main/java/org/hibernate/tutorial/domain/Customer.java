package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by aw on 23.09.16.
 */
public class Customer implements Serializable {
    long customerId;
    String name;
    String address;
    List<Order> orders;

    public Customer() {
    }

    public Customer(long customerId, String name, String address, List<Order> orders) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.orders = orders;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
