/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

 
import com.dhenton9000.birt.persistence.entities.Orders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.OrdersService;

/**
 * Jersey resource object for the Orders entity.
 * @author dhenton
 */

@Path("Orders")
@Api(value = "/Orders")
 
public class OrdersResources {
    
    
     @Autowired
     private OrdersService springService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Orders",notes = "lists all Orders at Classic Cars")
   
    public   List<Orders> getAllOrders() {
        return springService.getAllOrders();
        
    }
    
    
}
