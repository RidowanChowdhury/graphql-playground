package com.graphql.playground.controllers;

import com.graphql.playground.model.Customer;
import com.graphql.playground.services.CustomerService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @MutationMapping
//    @SchemaMapping(typeName = "Mutation", field = "addCustomer") // alternative
    public Customer addCustomer(@Argument String id, @Argument String name) {
        return customerService.addCustomer(new Customer(Integer.parseInt(id), name));
    }

    @QueryMapping
    public Customer customerById(@Argument String id) {
        return customerService.findByCustomer(Integer.parseInt(id));
    }

}
