/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service.impl;

 
 
import com.dhenton9000.birt.persistence.dao.OfficesDao;
import com.dhenton9000.birt.persistence.entities.Offices;
import com.dhenton9000.birt.persistence.service.OfficesService;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class OfficesServiceImpl   extends GenericEntityServiceImpl<Offices,String>
        implements OfficesService {

    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    private OfficesDao officesDao;
 
 

    @Override
    public List<Offices> getAllOffices() {

        return getOfficesDao().getAllOffices();
    }

    /**
     * @return the restaurantDao
     */
    public OfficesDao getOfficesDao() {
        return officesDao;
    }

    @Override
    public GenericDao<Offices, String> getDao() {
         return officesDao;
    }

    @Override
    public Offices getNew() {
         return new Offices();
    }

    @Override
    public Offices getNewWithDefaults() {
        return new Offices();
    }
    
}