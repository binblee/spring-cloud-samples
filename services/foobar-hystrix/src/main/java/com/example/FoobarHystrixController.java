package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/19/16.
 */

@RestController
@EnableCircuitBreaker
public class FoobarHystrixController {

    @Autowired
    private BarService barService;

    @RequestMapping(value = "message")
    public String getMessageFromBar(){
        return barService.getMessage();
    }
}
