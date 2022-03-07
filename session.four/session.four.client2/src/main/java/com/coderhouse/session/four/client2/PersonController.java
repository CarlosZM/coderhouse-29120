package com.coderhouse.session.four.client2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @GetMapping("/{personId}")
    public Person getPersonById(@PathVariable Integer personId) {
        return new Person(personId, "Carlos", "Zerga");
    }

    @GetMapping
    public List<Person> getPersonById() {
        return Arrays.asList(
                new Person(1, "Carlos", "Zerga"),
                new Person(2, "Carlos", "Zerga"),
                new Person(3, "Carlos", "Zerga"),
                new Person(4, "Carlos", "Zerga")
        );
    }
}
