
package com.dhenton9000.birt.dao;

import com.dhenton9000.birt.entities.Employees;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface EmployeeDao extends GenericDao<Employees, Integer> {
    
    public List<Employees> getAllEmployees();
}
