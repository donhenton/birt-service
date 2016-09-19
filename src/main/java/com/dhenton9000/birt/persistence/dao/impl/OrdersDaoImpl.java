
package com.dhenton9000.birt.persistence.dao.impl;

 
import com.dhenton9000.birt.persistence.entities.Orders;
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
import com.dhenton9000.birt.persistence.dao.OrdersDao;
import javax.persistence.Query;

@Repository
public class OrdersDaoImpl
        extends BaseHibernateGenericDaoImpl<Orders, Integer>
        implements OrdersDao {

    private static Logger  log = LoggerFactory.getLogger(OrdersDaoImpl.class);

    public OrdersDaoImpl() {
        super(Orders.class);
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
    public List<Orders> getAllOrders() {

        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Orders.findAll");

        List<Orders> res = this.find(new Orders(), template);

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

    @Override
    public List<Orders> getOrdersForOffice(String officeCode) {
        String qString = "select o "
                + " from Offices offices "
                + " join  office.employees   employees "
                + " join  employees.   e "
                + " where e.employeeNumber = :id ";
        
        Query q = this.getEntityManager().createQuery(qString);
        q.setParameter("id", officeCode);
        return   q.getResultList();
    }
}
