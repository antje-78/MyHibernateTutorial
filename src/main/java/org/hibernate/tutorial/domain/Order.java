package org.hibernate.tutorial.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

/**
 * Created by aw on 23.09.16.
 */
public class Order implements Serializable {
    public static class Id implements Serializable {
        long customerId;
        long orderNumber;

        public Id() {
        }

        public Id(long customerId, long orderNumber) {
            this.customerId = customerId;
            this.orderNumber = orderNumber;
        }

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public long getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(long orderNumber) {
            this.orderNumber = orderNumber;
        }
    }
    Id id;
    Calendar orderDate;
    Integer total;
    Customer customer;
    List<LineItem> lineItems;

    public Order() {
    }

    public Order(Id id, Calendar orderDate, Integer total, Customer customer, List<LineItem> lineItems) {
        this.id = id;
        this.orderDate = orderDate;
        this.total = total;
        this.customer = customer;
        this.lineItems = lineItems;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
