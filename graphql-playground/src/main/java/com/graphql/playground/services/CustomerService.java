package com.graphql.playground.services;

import com.graphql.playground.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CustomerService {

    private final Map<Integer, Customer> customerMap = new ConcurrentHashMap<Integer, Customer>();

    public Customer findByCustomer(int id) {
        return customerMap.get(id);
    }


    public Customer addCustomer(Customer customer) {
        customerMap.put(customer.id(), customer);
        return customer;
    }

}
