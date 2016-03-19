package com.example;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by libin on 3/19/16.
 */

@Service
public class BarService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @HystrixCommand(fallbackMethod = "getMessageFallback")
    public String getMessage() {
        ServiceInstance barInstance = loadBalancerClient.choose("bar");
        URI barUri = barInstance.getUri();
        RestTemplate restTemplate = new RestTemplate();
        String url = barUri + "/message";
        return restTemplate.getForObject(url, String.class);
    }

    public String getMessageFallback(){
        return "Bar service (fallback result)";
    }
}
