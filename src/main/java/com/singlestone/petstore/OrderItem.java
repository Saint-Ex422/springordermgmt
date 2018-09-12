package com.singlestone.petstore;

/**
 * Items that comprise an order
 */

public class OrderItem
{
    private String productId;
    private int quantity;
    private String name;
    private double unitPrice;

    public OrderItem() {
    }

    public OrderItem(String productId, int quantity, String name, double unitPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.name = name;
        this.unitPrice = unitPrice;
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

    public double getTotalPrice(){
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
