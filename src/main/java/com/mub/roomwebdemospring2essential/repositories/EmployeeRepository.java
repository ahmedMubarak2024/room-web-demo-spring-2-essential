package com.mub.roomwebdemospring2essential.repositories;

import com.mub.roomwebdemospring2essential.models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
