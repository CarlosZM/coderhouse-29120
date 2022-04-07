package com.coderhouse.session.twelve.basic;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomObjectMapperTest {

    @Test
    void testPersonSerialization() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        String text = "{\"first_name\":\"Carlos\",\"last_name\":\"Zerga\",\"number_of_brothers\":\"2\",\"birth_date\":\"2022-04-06T10:24:35.000000258\"}";

        CustomObjectMapper customObjectMapper = new CustomObjectMapper();

        Person person = customObjectMapper.deserializeToJson(text, Person.class);

        assertEquals(person, new Person("Carlos", "Zerga", "Carlos Zerga", 2, LocalDateTime.of(2022, 4, 6, 10, 24, 35, 258), 12));
    }


    @Test
    void testPersonDeserialization() throws InvocationTargetException, IllegalAccessException {
        Person person = new Person("Carlos", "Zerga", "Carlos Zerga", 2, LocalDateTime.of(2022, 4, 6, 10, 24, 35, 258), 12);

        CustomObjectMapper customObjectMapper = new CustomObjectMapper();

        String text = customObjectMapper.serializeToJson(person);

        assertEquals(text, "{\"first_name\":\"Carlos\",\"last_name\":\"Zerga\",\"number_of_brothers\":\"2\",\"birth_date\":\"2022-04-06T10:24:35.000000258\"}");
    }
}