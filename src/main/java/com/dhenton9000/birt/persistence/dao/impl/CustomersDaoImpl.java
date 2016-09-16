
package com.dhenton9000.birt.persistence.dao.impl;

 
import com.dhenton9000.birt.persistence.entities.Customers;
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
import com.dhenton9000.birt.persistence.dao.CustomersDao;
import com.dhenton9000.birt.persistence.entities.Orders;
import java.util.ArrayList;
import java.util.Set;

@Repository
public class CustomersDaoImpl
        extends BaseHibernateGenericDaoImpl<Customers, Integer>
        implements CustomersDao {

    private static Logger  log = LoggerFactory.getLogger(CustomersDaoImpl.class);

    public CustomersDaoImpl() {
        super(Customers.class);
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
    public List<Customers> getAllCustomers() {

        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Customers.findAll");

        List<Customers> res = this.find(new Customers(), template);

        return res;
    }
    
     @Override
    public List<Orders> getCustomerOrders(Integer id) {
        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Customers.findByid");
        template.addParameter("id", id);
        Customers c = this.findById(id);
         
        return new ArrayList(c.getOrders());
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
