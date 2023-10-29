package org.sid.billlingservice.services;

import org.sid.billlingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE") //basé sur framework OpenFeign4
public interface CustomerRestClient {
    @GetMapping(path = "/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id);
}