
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Customers;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface CustomersDao extends GenericDao<Customers, Integer> {
    
    public List<Customers> getAllCustomers();
}
