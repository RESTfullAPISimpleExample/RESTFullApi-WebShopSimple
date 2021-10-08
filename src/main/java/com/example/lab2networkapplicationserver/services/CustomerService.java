package com.example.lab2networkapplicationserver.services;


import com.example.lab2networkapplicationserver.data.DataBase;
import com.example.lab2networkapplicationserver.models.Customer;
import com.example.lab2networkapplicationserver.repo.CustomerRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;

//We are implementing our repository interface
public class CustomerService implements CustomerRepository {
    private ArrayList<Customer> customers;

    // Create an instance from our database
    public CustomerService() {
        this.customers = DataBase.getInstance().getAllCustomers();
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Response getOneCustomer(String ssn) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getSsn().equals(ssn)) {
                return Response.ok().entity(customers.get(i)).build();
            }
        }
        //If the customer does not exist in the database or if the input in wrong and should be in this form xxxxxxxx-xxxx
        return Response.status(Response.Status.NO_CONTENT).tag("There is no customer with this social security number " + ssn).build();
    }

    // Update the customer address
    @Override
    public Response updateCustomer(String ssn, Customer customer) {
        boolean customerExist = false;
        int customerIndex = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getSsn().equals(ssn)) {
                customerExist = true;
                customerIndex = i;
            }
        }
        if (!ssn.equals(customer.getSsn()) || !customerExist) {
            return Response.status(Response.Status.NO_CONTENT).tag("This customer does not exist in our system").build();
        }
        if (customerIndex != -1) {
            customers.set(customerIndex, customer);
            return Response.ok().entity(customers.get(customerIndex)).build();
        }
        return Response.status(Response.Status.NO_CONTENT).tag("THERE IS AN ERROR").build();
    }
}