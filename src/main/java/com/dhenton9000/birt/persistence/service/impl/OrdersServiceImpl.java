/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service.impl;

import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhenton9000.birt.persistence.service.OrdersService;
import com.dhenton9000.birt.persistence.dao.OrdersDao;

@Service
public class OrdersServiceImpl   extends GenericEntityServiceImpl<Orders, Integer> implements OrdersService {

    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    private OrdersDao ordersDao;
 
 

    @Override
    public List<Orders> getAllOrders() {

        return getOrdersDao().getAllOrders();
    }
    
    @Override
    public List<Orders> getOrdersForOffice(String officeCode)
    {
        return getOrdersDao().getOrdersForOffice(officeCode);
    }

    /**
     * @return the restaurantDao
     */
    public OrdersDao getOrdersDao() {
        return ordersDao;
    }

    @Override
    public GenericDao<Orders, Integer> getDao() {
         return ordersDao;
    }

    @Override
    public Orders getNew() {
         return new Orders();
    }

    @Override
    public Orders getNewWithDefaults() {
        return new Orders();
    }
    
}