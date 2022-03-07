package com.coderhouse.session.four.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person/v2")
public class PersonController {

    @Autowired
    private FeignRepository feignRepository;

    @GetMapping
    public List<Person> getData() {
        return this.feignRepository.getPersons();
    }
}
