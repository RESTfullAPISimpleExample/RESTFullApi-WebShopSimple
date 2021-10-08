package com.example.lab2networkapplicationserver.resources;


import com.example.lab2networkapplicationserver.models.Customer;
import com.example.lab2networkapplicationserver.repo.CustomerRepository;
import com.example.lab2networkapplicationserver.services.CustomerService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource implements CustomerRepository {

    private CustomerService customerService = new CustomerService();


    @Override
    @GET
    public ArrayList<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @Override
    @Path("/{ssn}")
    @GET
    public Response getOneCustomer(@PathParam("ssn") String ssn) {
        return customerService.getOneCustomer(ssn);
    }

    @Override
    @Path("/{ssn}")
    @PUT
    public Response updateCustomer(@PathParam("ssn") String ssn, Customer customer) {
        return customerService.updateCustomer(ssn, customer);
    }
}