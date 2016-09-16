/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service.impl;

 
 
import com.dhenton9000.birt.persistence.dao.ProductsDao;
import com.dhenton9000.birt.persistence.entities.Products;
import com.dhenton9000.birt.persistence.service.ProductsService;
import com.dhenton9000.jpa.dao.support.GenericDao;
import com.dhenton9000.jpa.service.support.GenericEntityServiceImpl;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class ProductsServiceImpl   extends GenericEntityServiceImpl<Products,String>
        implements ProductsService {

    @PersistenceContext()
    private EntityManager entityManager;
    @Autowired
    private ProductsDao ProductsDao;
 
 

    @Override
    public List<Products> getAllProducts() {

        return getProductsDao().getAllProducts();
    }

    /**
     * @return the restaurantDao
     */
    public ProductsDao getProductsDao() {
        return ProductsDao;
    }

    @Override
    public GenericDao<Products, String> getDao() {
         return ProductsDao;
    }

    @Override
    public Products getNew() {
         return new Products();
    }

    @Override
    public Products getNewWithDefaults() {
        return new Products();
    }
    
}