package com.example;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * Created by libin on 3/18/16.
 */
public class BarConfiguration {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(IClientConfig clientConfig){
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig){
        return new AvailabilityFilteringRule();
    }
}
