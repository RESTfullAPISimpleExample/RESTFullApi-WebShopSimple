package com.example.lab2networkapplicationserver.data;


import com.example.lab2networkapplicationserver.models.Customer;
import com.example.lab2networkapplicationserver.models.Order;

import java.util.ArrayList;

public class DataBase {

    private static DataBase dataBaseInstance = new DataBase();
    private ArrayList<Customer> customers;

    public static DataBase getInstance() {
        return dataBaseInstance;
    }

    // Create a hard coded database Customers and Orders
    private DataBase() {
        customers = new ArrayList<>();
        customers.add(new Customer("19890621-9699", "Muhannad Satouf",
                String.valueOf(Customer.Gender.Male), "Ängsvägen 19 A", "29133", "Kristianstad"));
        customers.add(new Customer("19920102-6326", "Btoul Tarbouch ",
                String.valueOf(Customer.Gender.Female), "Ängsvägen 19 A", "29133", "Kristianstad"));


        ArrayList<Order> orders = new ArrayList<>();
        orders.add(new Order("2021-10-10", 15000, String.valueOf(Order.Status.NotPayed)));
        orders.add(new Order("2021-08-13", 2000, String.valueOf(Order.Status.Payed)));
        customers.get(0).setOrders(orders);

        orders = new ArrayList<>();
        orders.add(new Order("2021-10-05", 150, String.valueOf(Order.Status.Payed)));
        orders.add(new Order("2019-09-05", 750, String.valueOf(Order.Status.NotPayed)));
        customers.get(1).setOrders(orders);
    }

    // Return the customers Arraylist
    public ArrayList<Customer> getAllCustomers() {
        return customers;
    }
}
