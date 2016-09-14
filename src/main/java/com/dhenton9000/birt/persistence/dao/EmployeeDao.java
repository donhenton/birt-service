
package com.dhenton9000.birt.persistence.dao;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface EmployeeDao extends GenericDao<Employees, Integer> {
    
    public List<Employees> getAllEmployees();
}
