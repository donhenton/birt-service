/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

 
import com.dhenton9000.birt.persistence.entities.Offices;
import com.dhenton9000.birt.persistence.service.EmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.OfficesService;
import javax.ws.rs.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jersey resource object for the offices entity.
 * @author dhenton
 */

@Path("offices")
@Api(value = "/offices")
 
public class OfficesResources {
    
    private static Logger  log = LoggerFactory.getLogger(OfficesResources.class);
     @Autowired
     private OfficesService springService;
     @Autowired
     private EmployeesService employeesService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Offices",notes = "lists all employees at Classic Cars")
   
    public   List<Offices> getAllOffices() {
        return springService.getAllOffices();
        
    }
    
    
    @GET
    @Path("/get/{officeCode}/employees")
    @ApiOperation(value = "Get Employees for an Office", notes = "lists all employees at Classic Cars in this office")
    public   OfficesEmployeesResource getEmployeesForOffice(@PathParam("officeCode") String officeCode) {
        
        return  new OfficesEmployeesResource(officeCode,employeesService);
        
    }
    
}
