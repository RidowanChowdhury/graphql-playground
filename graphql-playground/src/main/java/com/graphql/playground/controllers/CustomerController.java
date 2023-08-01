package com.graphql.playground.controllers;

import com.graphql.playground.model.Customer;
import com.graphql.playground.model.Profile;
import com.graphql.playground.services.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @QueryMapping
//    @SchemaMapping(typeName = "Query", field = "customers") // alternative
    public List<Customer> customers() {
        return customerService.customerList();
    }

    @QueryMapping
    public Customer customerById(@Argument String id) {
        return customerService.findByCustomer(Integer.parseInt(id));
    }

    @SchemaMapping
    public Profile profile(Customer customer) {
        System.out.println(customer.id()); // n+1 problem
        return customerService.getProfile(customer);
    }
}
