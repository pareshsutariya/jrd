package net.xitiz.jrd.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping()
    public String helloWorld() {
        return "Hello JRD !!";
    }

}
