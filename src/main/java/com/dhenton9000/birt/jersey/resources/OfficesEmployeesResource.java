package com.dhenton9000.birt.jersey.resources;

import com.dhenton9000.birt.persistence.entities.Employees;
import com.dhenton9000.birt.persistence.entities.Orders;
import com.dhenton9000.birt.persistence.service.EmployeesService;
import com.dhenton9000.birt.persistence.service.OrdersService;
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
    private static Logger log = LoggerFactory.getLogger(OfficesEmployeesResource.class);
    private final EmployeesService employeesService;
    private final OrdersService ordersService;

    OfficesEmployeesResource(String officeCode, EmployeesService employeesService, OrdersService ordersService) {

        this.officeCode = officeCode;
        this.employeesService = employeesService;
        this.ordersService = ordersService;
    }

    /**
     * @return the officeId
     */
    public String getOfficeCode() {
        return officeCode;
    }

    @GET
    @Path("/employees/listing")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get Employees for an Office", notes = "lists all employees at Classic Cars in this office")
    public List<Employees> getAllEmployees() {

        return employeesService.getEmployeesForOffice(getOfficeCode());

    }

    @GET
    @Path("/orders")
    @Produces({MediaType.APPLICATION_JSON})
    @ApiOperation(value = "Get Orders for an Office", notes = "lists all orders originating at this office")
    public List<Orders> getOrders() {

        return ordersService.getOrdersForOffice(getOfficeCode());

    }

}
