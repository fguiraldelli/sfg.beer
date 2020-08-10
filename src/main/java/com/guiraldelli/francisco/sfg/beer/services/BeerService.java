package com.guiraldelli.francisco.sfg.beer.services;

import com.guiraldelli.francisco.sfg.beer.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
}
