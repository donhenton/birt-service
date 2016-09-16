/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.dao.impl;

 
import com.dhenton9000.birt.persistence.dao.ProductsDao;
import com.dhenton9000.birt.persistence.entities.Products;
import com.dhenton9000.jpa.dao.hibernate.BaseHibernateGenericDaoImpl;
import com.dhenton9000.jpa.dao.support.NamedQueryUtil;
import com.dhenton9000.jpa.dao.support.SearchTemplate;
import java.util.List;
import org.slf4j.LoggerFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductsDaoImpl
        extends BaseHibernateGenericDaoImpl<Products,String>
        implements ProductsDao {

    private static Logger  log = LoggerFactory.getLogger(ProductsDaoImpl.class);

    public ProductsDaoImpl() {
        super(Products.class);
    }

    @PersistenceContext
    @Override
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    @Override
    public void setNamedQueryUtil(NamedQueryUtil namedQueryUtil) {
        this.namedQueryUtil = namedQueryUtil;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Products> getAllProducts() {

        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Products.findAll");

        List<Products> res = this.find(new Products(), template);

        return res;
    }
/*
    @Override
    public List<Restaurant> getRestaurantsWithMaxRating(int ratingLimit) {
         SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Restaurant.maxRating");
        template.addParameter("ratingLimit", ratingLimit);

        List<Restaurant> found = this.find(new Restaurant(), template);
        return found;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Restaurant> getRestaurantsLike(String searchString) {

        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Restaurant.nameLike");
        template.addParameter("searchString", "%"+searchString+"%");

        List<Restaurant> found = this.find(new Restaurant(), template);
        return found;
    }
*/
}
