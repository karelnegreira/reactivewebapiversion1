package com.karelcode.postgressample.controller;

import com.karelcode.postgressample.model.Employee;
import com.karelcode.postgressample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Controller {
    @Autowired
    EmployeeRepository repository;

    @GetMapping("/getemployeebyid/{id}")
    public Mono<Employee> getById(@PathVariable("id") Integer id) {
        return repository.findById(id);
    }

    @GetMapping("/allemployee")
    public Flux<Employee> findAll() {
        return repository.findAll();
    }

    @GetMapping("/getallbyname/{name}")
    public Flux<Employee> findByName(@PathVariable("name") String name) {
        return repository.findByName(name);
    }

    @PostMapping("/save/{employee}")
    public Mono<Employee> save(Employee employee) {
        return repository.save(employee);
    }
}
