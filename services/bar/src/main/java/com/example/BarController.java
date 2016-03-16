package com.example;

import com.example.model.BarMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class BarController {

    @RequestMapping("/message")
    BarMessage getMessage() {
        BarMessage barmsg = new BarMessage();
        barmsg.setMessage("Greeting from Bar Service.");
        return barmsg;
    }
}
