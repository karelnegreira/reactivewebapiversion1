package com.karelcode.postgressample.repository;

import com.karelcode.postgressample.model.Employee;
import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
    @Query("select * from employee")
    Flux<Employee> findAll();

    @Query("select * from employee where name = $1")
    Flux<Employee> findByName(String name);
}
