package com.coderhouse.session.four.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/person")
public class PersonController {

    @GetMapping
    public String hi() {
        return "HELLO";
    }
}
