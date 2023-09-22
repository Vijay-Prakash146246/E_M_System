package com.Employee.Data.repo;

import com.Employee.Data.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee,String>
{
}
