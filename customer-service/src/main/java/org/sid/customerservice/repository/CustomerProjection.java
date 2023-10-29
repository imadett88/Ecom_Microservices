package org.sid.customerservice.repository;

import org.sid.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();
}
