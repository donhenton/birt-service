/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

import com.dhenton9000.birt.persistence.entities.Customers;
import com.dhenton9000.birt.persistence.entities.Orders;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.CustomersService;
import javax.ws.rs.PathParam;

/**
 * Jersey resource object for the Customers entity.
 *
 * @author dhenton
 */
@Path("customers")
@Api(value = "/customers")

public class CustomersResources {

    @Autowired
    private CustomersService customerService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All Customers", notes = "lists all Customers at Classic Cars")

    public List<Customers> getAllCustomers() {
        return customerService.getAllCustomers();

    }

    @GET
    @Path("/get/orders/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Orders for a customer", notes = "lists orders for a given customer")

    public List<Orders> getCustomerOrders(@PathParam("id") Integer id) {
        return customerService.getCustomerOrders(id);

    }
}
