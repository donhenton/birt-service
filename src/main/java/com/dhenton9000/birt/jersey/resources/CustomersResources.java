/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

 
import com.dhenton9000.birt.persistence.entities.Customers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.CustomersService;

/**
 * Jersey resource object for the Customers entity.
 * @author dhenton
 */

@Path("Customers")
@Api(value = "/Customers")
 
public class CustomersResources {
    
    
     @Autowired
     private CustomersService springService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Customers",notes = "lists all Customers at Classic Cars")
   
    public   List<Customers> getAllCustomers() {
        return springService.getAllCustomers();
        
    }
    
    
}
