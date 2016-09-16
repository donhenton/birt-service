/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service;

import com.dhenton9000.birt.persistence.entities.Customers;
import com.dhenton9000.birt.persistence.entities.Orders;
import java.util.List;


/**
 *
 * @author dhenton
 */
public interface CustomersService {
    
    public List<Customers> getAllCustomers();
    public List<Orders> getCustomerOrders(Integer id);
}
