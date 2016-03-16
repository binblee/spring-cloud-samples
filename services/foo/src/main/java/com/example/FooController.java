package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/15/16.
 */

@RefreshScope
@RestController
public class FooController {

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    String getMessage(){
        return this.message;
    }
}