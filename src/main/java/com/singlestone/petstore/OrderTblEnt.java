package com.singlestone.petstore;

/*
    Order equivalent entity used to map to db table
 */

import com.singlestone.petstore.OrderItemsTblEnt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Order")
@Table(name = "orders")
public class OrderTblEnt {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long orderId;

    private String customerId;

    @OneToMany(mappedBy = "orderTblEnt",
    cascade = CascadeType.ALL,
    orphanRemoval = true)
    private List<OrderItemsTblEnt> orderItems = new ArrayList<>();

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderItemsTblEnt> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemsTblEnt> orderItems) {
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItemsTblEnt orderItem){
        orderItems.add(orderItem);
        orderItem.setOrderTblEnt(this);
    }

    public void removeOrderItem(OrderItemsTblEnt orderItem){
        orderItems.remove(orderItem);
        orderItem.setOrderTblEnt(null);
    }
}
