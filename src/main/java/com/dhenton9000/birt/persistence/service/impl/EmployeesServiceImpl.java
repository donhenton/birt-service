/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service.impl;

import com.dhenton9000.birt.persistence.dao.EmployeeDao;
import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dhenton9000.birt.persistence.service.EmployeesService;

@Service
public class EmployeesServiceImpl   extends GenericEntityServiceImpl<Employees, Integer> implements EmployeesService {

    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    private EmployeeDao employeeDao;
 
 

    @Override
    public List<Employees> getAllEmployees() {

        return getEmployeeDao().getAllEmployees();
    }

    /**
     * @return the restaurantDao
     */
    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public GenericDao<Employees, Integer> getDao() {
         return employeeDao;
    }

    @Override
    public Employees getNew() {
         return new Employees();
    }

    @Override
    public Employees getNewWithDefaults() {
        return new Employees();
    }
    
}