package com.example.lab2networkapplicationserver.repo;

import com.example.lab2networkapplicationserver.models.Customer;

import java.util.ArrayList;

import javax.ws.rs.core.Response;

public interface CustomerRepository {

    ArrayList<Customer> getCustomers();

    Response getOneCustomer(String ssn);

    Response updateCustomer(String ssn, Customer customer);

}
