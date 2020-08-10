package com.guiraldelli.francisco.sfg.beer.services;

import com.guiraldelli.francisco.sfg.beer.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
