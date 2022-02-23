package com.coderhouse.session.two.orm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT p FROM Person p WHERE p.age>:age")
    List<Person> getFiltered(Integer age);

    List<Person> getAllByAgeGreaterThan(Integer age);
}
