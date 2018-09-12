package com.singlestone.petstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetStoreController {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    EntityConverter entityConverter;


    @RequestMapping("/submitOrder")
    public String submitOrder(@RequestBody Order body){

        long orderId = orderRepository.insert(entityConverter.convertOrderToOrderEnt(body));
        System.out.println("Order Id: "+orderId);

        Order order = entityConverter.convertOrderEntToOrder(orderRepository.find(1));


        return "Successfully created order with order id: "+orderId;
    }

    @RequestMapping("/getOrder")
    public String getOrder(@RequestParam long orderId){
        Order order = entityConverter.convertOrderEntToOrder(orderRepository.find(orderId));

        return order.toString();
    }

}
