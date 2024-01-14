package com.apacheExample.taxibookdriver.controller;

import com.apacheExample.taxibookdriver.service.TaxiLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class TaxiLocationController {

    @Autowired
    private TaxiLocationService taxiLocationService;

    @PutMapping
    public ResponseEntity updateLocation(){

        int range = 100;
        while(range > 0){
            taxiLocationService.updateLocaltion(Math.random()+ " , "+ Math.random());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            range--;
        }
        return new ResponseEntity<>(Map.of("message","Location Updated"), HttpStatus.OK);
    }
}
