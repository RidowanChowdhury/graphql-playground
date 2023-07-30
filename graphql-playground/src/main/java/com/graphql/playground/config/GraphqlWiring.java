package com.graphql.playground.config;

import com.graphql.playground.datafetchers.CustomerDataFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphqlWiring {

    private final CustomerDataFetcher customerDatafetcher;

    public GraphqlWiring(CustomerDataFetcher customerDatafetcher) {
        this.customerDatafetcher = customerDatafetcher;
    }

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return builder -> {
            builder.type("Query",
                    wiring -> wiring.dataFetcher("customers", env -> customerDatafetcher.customerList())
                            .dataFetcher("customerById", env -> customerDatafetcher.findByCustomer(Integer.parseInt(env.getArgument("id")))));
            builder.type("Customer", wiring -> wiring.dataFetcher("profile", env -> customerDatafetcher.getProfile(env.getSource())));
        };
    }
}
