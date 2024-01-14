package com.apacheExample.taxibookdriver.service;


import com.apacheExample.taxibookdriver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TaxiLocationService {
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    public boolean updateLocaltion(String location){
        kafkaTemplate.send(AppConstant.TAXI_LOCATION,location);
        return true;
    }
}
