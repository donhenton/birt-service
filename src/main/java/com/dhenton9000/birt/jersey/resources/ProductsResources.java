/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.birt.jersey.resources;

 
import com.dhenton9000.birt.persistence.entities.Products;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import com.dhenton9000.birt.persistence.service.ProductsService;

/**
 * Jersey resource object for the products entity.
 * @author dhenton
 */

@Path("products")
@Api(value = "/products")
 
public class ProductsResources {
    
    
     @Autowired
     private ProductsService springService;

    @GET
    @Path("/get/all")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get All products",notes = "lists all products at Classic Cars")
   
    public   List<Products> getAllProducts() {
        return springService.getAllProducts();
        
    }
    
    
}
