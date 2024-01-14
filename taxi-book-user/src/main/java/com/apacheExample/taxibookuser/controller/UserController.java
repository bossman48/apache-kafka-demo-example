package com.apacheExample.taxibookuser.controller;


import com.apacheExample.taxibookuser.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<String> getLocationAsAList(){
        return locationService.getTaxiLocation();
    }
}
