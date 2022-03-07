package com.coderhouse.session.four.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("session.four.eureka.client2")
public interface FeignRepository {

    @RequestMapping(value = "/api/person", method = RequestMethod.GET)
    List<Person> getPersons();
}
