package com.guiraldelli.francisco.sfg.beer.web.controller;

import com.guiraldelli.francisco.sfg.beer.services.BeerService;
import com.guiraldelli.francisco.sfg.beer.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.guiraldelli.francisco.sfg.beer.utils.Constants.SERVER_HOST;

@RequestMapping("api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {

        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", SERVER_HOST + "/api/v1/beer/" +
                savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //when you cannot need to pass a header you can use this annotation
    public void handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        beerService.updateBeer(beerId, beerDto);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT) //when you cannot need to pass a header you can use this annotation
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
    }
}
