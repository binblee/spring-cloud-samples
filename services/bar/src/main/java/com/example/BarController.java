package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class BarController {

    @RequestMapping("/message")
    String getMessage(){
        return "Bar Message.";
    }
}
