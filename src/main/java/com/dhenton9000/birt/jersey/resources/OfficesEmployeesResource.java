package com.dhenton9000.birt.jersey.resources;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.service.EmployeesService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author dhenton
 */
public class OfficesEmployeesResource {

    private final String officeCode;
    private static Logger  log = LoggerFactory.getLogger(OfficesEmployeesResource.class);
    private final EmployeesService employeesService;

    

    OfficesEmployeesResource(String officeCode, EmployeesService employeesService) {
        
        this.officeCode = officeCode;
        this.employeesService = employeesService;
    }

    /**
     * @return the officeId
     */
    public String getOfficeCode() {
        return officeCode;
    }

    @GET
    @Path("/listing")
    @Produces({MediaType.APPLICATION_JSON})
   

    public List<Employees> getAllEmployees() {
         
        return employeesService.getEmployeesForOffice(getOfficeCode());

    }

}
