/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.rest;

import com.udea.entity.Customer;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ejb.EJB;

/**
 * REST Web Service
 *
 * @author felipe
 */
@Path("customer")
public class CustomerREST {

    @Context
    private UriInfo context;

    @EJB
    private CustomerFacade customerFacade;

    /**
     * Creates a new instance of CustomerREST
     */
    public CustomerREST() {
    }

    /**
     * Retrieves representation of an instance of com.udea.rest.CustomerREST
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public List<Customer> getJson() {
        return customerFacade.findAll();
    }

    @GET
    @Path("/search/{name}")
    @Produces("application/json")
    public List<Customer> findByName(@PathParam("name") String name) {
        return customerFacade.findByName(name);
    }

    /**
     * PUT method for updating or creating an instance of CustomerREST
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
