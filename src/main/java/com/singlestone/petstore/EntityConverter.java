package com.singlestone.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class EntityConverter {

    /**
     * This class converts between pojo's used for sending and receiving JSON data and the entities used to represent
     * rows in the db
     */

    @Autowired
    ItemEnricher itemEnricher;

    public OrderTblEnt convertOrderToOrderEnt(Order order){
        OrderTblEnt orderTblEnt = new OrderTblEnt();
        orderTblEnt.setCustomerId(order.getCustomerId());
        orderTblEnt.setOrderItems(Arrays.stream(order.getItems())
        .map( o -> new OrderItemsTblEnt(o.getProductId(),o.getQuantity(),
                itemEnricher.getItemDetail(o.getProductId()).getName(),
                itemEnricher.getItemDetail(o.getProductId()).getPrice(), orderTblEnt))
        .collect(Collectors.toList()));

        return orderTblEnt;
    }

    public Order convertOrderEntToOrder(OrderTblEnt orderTblEnt){
        Order order = new Order();
        order.setCustomerId(orderTblEnt.getCustomerId());
        order.setItems(orderTblEnt.getOrderItems().stream()
        .map(o-> new OrderItem(o.getProductId(),o.getQuantity(),o.getName(),o.getUnitPrice()))
                .toArray(OrderItem[]::new));

        return order;
    }
}
