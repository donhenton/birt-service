
package com.dhenton9000.birt.dao;

import com.dhenton9000.birt.entities.Employee;
import com.dhenton9000.jpa.dao.support.GenericDao;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface EmployeeDao extends GenericDao<Employee, Integer> {
    
    public List<Employee> getAllEmployees();
}
