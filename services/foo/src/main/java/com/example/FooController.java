package com.example;

import com.example.model.FooMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(FooController.class);

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    FooMessage getMessage(){
        FooMessage foomsg = new FooMessage();
        foomsg.setName("Foo Service");
        foomsg.setMessage(message);
        return foomsg;
    }
}
