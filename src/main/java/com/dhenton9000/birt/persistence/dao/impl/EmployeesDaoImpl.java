/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.dao.impl;

 
import com.dhenton9000.birt.persistence.entities.Employees;
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
import com.dhenton9000.birt.persistence.dao.EmployeesDao;
import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.birt.persistence.entities.SalesReport;
import javax.persistence.Query;

@Repository
public class EmployeesDaoImpl
        extends BaseHibernateGenericDaoImpl<Employees, Integer>
        implements EmployeesDao {

    private static Logger  log = LoggerFactory.getLogger(EmployeesDaoImpl.class);

    public EmployeesDaoImpl() {
        super(Employees.class);
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
    public List<Employees> getAllEmployees() {

        SearchTemplate template = new SearchTemplate();
        template.setNamedQuery("Employees.findAll");

        List<Employees> res = this.find(new Employees(), template);

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
    
    String query = "SELECT NEW CustomObject(i.firstProperty, i.secondProperty) FROM ObjectName i WHERE i.id=10";
TypedQuery<CustomObject> typedQuery = em.createQuery(query , CustomObject.class);
List<CustomObject> results = typedQuery.getResultList();
    
    
*/
//http://www.objectdb.com/java/jpa/query/jpql/select
    @Override
    public List<Orders> getOrdersForEmployee(Integer employeeId) {
        
       
        String qString = "select o "
                + " from Orders o "
                + " join  o.customer   cust "
                + " join  cust.employee   e "
                + " where e.employeeNumber = :id ";
        
        Query q = this.getEntityManager().createQuery(qString);
        q.setParameter("id", employeeId);
        List orders = q.getResultList();
        
      //   http://www.objectdb.com/java/jpa/query/jpql/select
        
        return orders;
    }
    
    @Override
    public List<SalesReport> getSalesData() {
        
       
        String qString = "select  new com.dhenton9000.birt."
                + "persistence.entities.SalesReport(e.firstName, e.lastName,"
                + "SUM(details.priceEach),e.employeeNumber)"
                + " from  Orders o"
                + " join  o.orderDetails details"
                + " join  o.customer   cust "
                + " join  cust.employee   e "
                + " GROUP BY e.employeeNumber"
                + " ORDER BY e.lastName, e.firstName";
                
        
        Query q = this.getEntityManager().createQuery(qString);
        //q.setParameter("id", employeeId);
        List<SalesReport> salesData = q.getResultList();
        
      //   http://www.objectdb.com/java/jpa/query/jpql/select
        
        return salesData;
    }
    
}
