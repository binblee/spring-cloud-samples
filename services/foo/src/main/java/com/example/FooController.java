package com.example;

import com.example.model.FooMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/15/16.
 */

@RefreshScope
@RestController
public class FooController {

    private static final Logger log = LoggerFactory.getLogger(FooController.class);

    @Value("${message}")
    private String message;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/message")
    public FooMessage getMessage(){
        FooMessage foomsg = new FooMessage();
        foomsg.setName(getLocalInstanceInfo());
        foomsg.setMessage(message);
        return foomsg;
    }

    private String getLocalInstanceInfo(){
        ServiceInstance serviceInstance = discoveryClient.getLocalServiceInstance();
        return serviceInstance.getServiceId() + ":" + serviceInstance.getHost() +
                ":" + serviceInstance.getPort();
    }
}
