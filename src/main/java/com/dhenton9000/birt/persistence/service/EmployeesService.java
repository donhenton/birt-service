/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.persistence.service;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.birt.persistence.entities.SalesReport;
import java.util.List;

/**
 *
 * @author dhenton
 */
public interface EmployeesService {
    
    public List<Employees> getAllEmployees();
    public List<Orders> getOrdersForEmployee(Integer employeeId);
    public List<SalesReport> getSalesData();
    public List<Employees> getEmployeesForOffice(String officeCode);
    public Employees getById(Integer employeeId);
}
