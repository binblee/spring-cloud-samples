package com.example;

import com.example.model.BarMessage;
import com.example.model.FooMessage;
import com.example.model.FoobarMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by libin on 3/16/16.
 */

@RestController
public class FoobarController {

    @RequestMapping("/message")
    FoobarMessage getMessage(){

        FooMessage foo = new FooMessage();
        foo.setName("foo");
        foo.setMessage("foo msg");

        BarMessage bar = new BarMessage();
        bar.setMessage("bar message");

        FoobarMessage foobar = new FoobarMessage();
        foobar.setBar(bar);
        foobar.setFoo(foo);
        return foobar;
    }
}
