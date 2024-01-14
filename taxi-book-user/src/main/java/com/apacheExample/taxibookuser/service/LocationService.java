package com.apacheExample.taxibookuser.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    List<String> locationOfTheDriver = new ArrayList<String>();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    @KafkaListener(topics = "taxi-location", groupId = "user-group")
    public  void taxiLocation(String location){

        LocalDateTime now = LocalDateTime.now();
        locationOfTheDriver.add(dtf.format(now).toString()+" : "+ location);

    }

    public List<String > getTaxiLocation(){
        return locationOfTheDriver;
    }
}
