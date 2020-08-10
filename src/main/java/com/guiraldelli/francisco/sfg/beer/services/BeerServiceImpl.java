package com.guiraldelli.francisco.sfg.beer.services;

import com.guiraldelli.francisco.sfg.beer.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto) {
        //todo impl
        log.debug("Updating beer: \n" + beerDto.toString());
    }

    @Override
    public void deleteBeerById(UUID beerId) {
        log.debug("Deleting beer: " + beerId.toString());
    }

}
