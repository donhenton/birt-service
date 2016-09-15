
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface OrdersDao extends GenericDao<Orders, Integer> {
    
    public List<Orders> getAllOrders();
}
