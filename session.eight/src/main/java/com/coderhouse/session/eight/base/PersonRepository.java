package com.coderhouse.session.eight.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

}
