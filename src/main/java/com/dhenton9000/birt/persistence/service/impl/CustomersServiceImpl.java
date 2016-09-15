/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service.impl;

import com.dhenton9000.birt.persistence.entities.Customers;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhenton9000.birt.persistence.service.CustomersService;
import com.dhenton9000.birt.persistence.dao.CustomersDao;

@Service
public class CustomersServiceImpl   extends GenericEntityServiceImpl<Customers, Integer> implements CustomersService {

    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    private CustomersDao employeeDao;
 
 

    @Override
    public List<Customers> getAllCustomers() {

        return getEmployeeDao().getAllCustomers();
    }

    /**
     * @return the restaurantDao
     */
    public CustomersDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public GenericDao<Customers, Integer> getDao() {
         return employeeDao;
    }

    @Override
    public Customers getNew() {
         return new Customers();
    }

    @Override
    public Customers getNewWithDefaults() {
        return new Customers();
    }
    
}