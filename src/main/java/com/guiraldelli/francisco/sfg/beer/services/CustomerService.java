package com.guiraldelli.francisco.sfg.beer.services;

import com.guiraldelli.francisco.sfg.beer.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customerDto);

    void updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);
}
