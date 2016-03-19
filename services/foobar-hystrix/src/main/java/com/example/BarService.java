package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by libin on 3/19/16.
 */

@Service
public class BarService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMessageFallback")
    public String getMessage() {
        return restTemplate.getForObject("http://bar/message", String.class);
    }

    public String getMessageFallback(){
        return "Bar service (fallback result)";
    }
}
