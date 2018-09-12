package com.singlestone.petstore;

import java.util.Arrays;

/**
 * represents an order submitted and returned by service
 */

public class Order {

    private String customerId;
    private OrderItem[] items;
    private double orderPrice = -1;

    public Order() {
    }

    public Order(String customerId, OrderItem[] items) {
        this.customerId = customerId;
        this.items = items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderItem[] getItems() {
        return items;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setItems(OrderItem[] items) {
        this.items = items;
    }

    public double getOrderPrice() {
        if(orderPrice<0){
            calcOrderPrice();
        }
        return orderPrice;
    }

    private void calcOrderPrice() {
        int price = 0;

        for(OrderItem i : items)
            price+= i.getTotalPrice();
        orderPrice = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerId='" + customerId + '\'' +
                ", items=" + Arrays.toString(items) +
                ", orderPrice=" + getOrderPrice() +
                '}';
    }
}
