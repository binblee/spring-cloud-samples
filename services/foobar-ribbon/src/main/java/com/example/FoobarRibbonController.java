package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by libin on 3/18/16.
 */

@RestController
@RibbonClient(name = "bar", configuration = BarConfiguration.class)
public class FoobarRibbonController {

    @LoadBalanced
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/message")
    public String getMessage(){

        String message = restTemplate.getForObject("http://bar/message",String.class);
        return message;
    }
}
