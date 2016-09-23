package org.hibernate.tutorial.domain;

import java.io.Serializable;

/**
 * Created by aw on 23.09.16.
 */
public class LineItem implements Serializable {
    public static class Id implements Serializable {
        long customerId;
        long orderNumber;
        long productId;

        public Id() {
        }

        public Id(long customerId, long orderNumber) {
            this.customerId = customerId;
            this.orderNumber = orderNumber;
        }

        public Id(long customerId, long orderNumber, long productId) {
            this.customerId = customerId;
            this.orderNumber = orderNumber;
            this.productId = productId;
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

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }
    }
    Id id;
    Integer quantity;
    Order order;
    Product product;

    public LineItem() {
    }

    public LineItem(Id id, Integer quantity, Order order, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
