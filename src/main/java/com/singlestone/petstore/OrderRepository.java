package com.singlestone.petstore;

/*
 * persists order to db
 */

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public long insert(OrderTblEnt orderTblEnt){
        entityManager.persist(orderTblEnt);
        return orderTblEnt.getOrderId();
    }

    public OrderTblEnt find(long id){
        return entityManager.find(OrderTblEnt.class,id);
    }
}
