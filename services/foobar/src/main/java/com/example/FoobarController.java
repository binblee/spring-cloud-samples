package com.example;

import com.example.model.BarMessage;
import com.example.model.FooMessage;
import com.example.model.FoobarMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class FoobarController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private static final Logger log = LoggerFactory.getLogger(FoobarController.class);

    private static final String FOO_SERVICE_NAME = "foo";
    private static final String BAR_SERVICE_NAME = "bar";

    @RequestMapping("/message")
    FoobarMessage getMessage(){
        BarMessage bar = getMessageFromBarService();
        FooMessage foo = getMessageFromFooService();
        FoobarMessage foobar = new FoobarMessage();
        foobar.setBar(bar);
        foobar.setFoo(foo);

        log.debug("Result foobar message: {}.",foobar);
        return foobar;
    }

    private BarMessage getMessageFromBarService(){
        RestTemplate restTemplate = new RestTemplate();
        URI barUri = fetchServiceURI(BAR_SERVICE_NAME);
        String barUriString = barUri + "/message";
        BarMessage bar = restTemplate.getForObject(barUriString, BarMessage.class);
        log.debug("From bar service @ {}: {}.", barUriString, bar);
        return bar;
    }

    private FooMessage getMessageFromFooService(){
        RestTemplate restTemplate = new RestTemplate();
        URI fooUri = fetchServiceURI(FOO_SERVICE_NAME);
        String fooUriString = fooUri + "/message";
        FooMessage foo = restTemplate.getForObject(fooUriString, FooMessage.class);
        log.debug("From foo service @ {}: {}.", fooUriString, foo);
        return foo;
    }

    private URI fetchServiceURI(String serviceName){
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceName);
        return serviceInstance.getUri();
    }
}
