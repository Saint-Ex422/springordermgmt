package com.singlestone.petstore;

/**
 * OrderItem equivalent used to map to db table
 */


import javax.persistence.*;

@Entity(name = "OrderItem")
@Table(name = "order_item")
public class OrderItemsTblEnt {

    @Id
    @GeneratedValue
    private Long id;

    private String productId;
    private int quantity;
    private String name;
    private double unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderTblEnt orderTblEnt;

    public OrderItemsTblEnt() {
    }

    public OrderItemsTblEnt(String productId, int quantity, String name, double unitPrice, OrderTblEnt orderTblEnt) {
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.unitPrice = unitPrice;
        this.orderTblEnt = orderTblEnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderTblEnt getOrderTblEnt() {
        return orderTblEnt;
    }

    public void setOrderTblEnt(OrderTblEnt orderTblEnt) {
        this.orderTblEnt = orderTblEnt;
    }
}
