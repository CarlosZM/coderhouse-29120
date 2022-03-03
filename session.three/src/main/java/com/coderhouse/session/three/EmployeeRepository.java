package com.coderhouse.session.three;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}
