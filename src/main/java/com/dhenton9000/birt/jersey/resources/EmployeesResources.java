/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

 
import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiModel;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Jersey resource object for the employees entity.
 * @author dhenton
 */

@Path("employees")
@Api(value = "/employees")
 
public class EmployeesResources {
    
    
     @Autowired
     private EmployeeService springService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Employees")
   
    public   List<Employees> getAllEmployees() {
        return springService.getAllEmployees();
        
    }
    
    
}
