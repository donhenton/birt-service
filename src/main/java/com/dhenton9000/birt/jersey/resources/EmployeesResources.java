/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.entities.Orders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.EmployeesService;
import javax.ws.rs.PathParam;

/**
 * Jersey resource object for the employees entity.
 *
 * @author dhenton
 */
@Path("employees")
@Api(value = "/employees")

public class EmployeesResources {

    @Autowired
    private EmployeesService springService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Employees", notes = "lists all employees at Classic Cars")

    public List<Employees> getAllEmployees() {
        return springService.getAllEmployees();

    }

    @GET
    @Path("/get/employee/orders/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Employees", notes = "orders for an employee")
    public List<Orders> getOrdersForEmployee(@PathParam("id") Integer employeeId) {
        return springService.getOrdersForEmployee(employeeId);
    }
}
