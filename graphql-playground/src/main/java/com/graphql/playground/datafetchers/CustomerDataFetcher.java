package com.graphql.playground.datafetchers;

import com.graphql.playground.model.Customer;
import com.graphql.playground.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDataFetcher {

    public List<Customer> customerList() {
        return List.of(new Customer(1, "Ryan"), new Customer(2, "Murphy"));
    }

    public Customer findByCustomer(int id) {
        return new Customer(id, id == 1 ? "Ryan" : "Murphy");
    }

    public Profile getProfile(Customer customer) {
        return new Profile(customer.id(), customer.id());
    }
}
