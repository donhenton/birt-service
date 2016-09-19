
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.birt.persistence.entities.SalesReport;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface EmployeesDao extends GenericDao<Employees, Integer> {
    
    public List<Employees> getAllEmployees();
    public List<Orders> getOrdersForEmployee(Integer employeeId);
    public List<SalesReport> getSalesData();
    
}
