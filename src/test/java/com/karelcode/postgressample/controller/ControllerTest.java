package com.karelcode.postgressample.controller;

import com.karelcode.postgressample.model.Employee;
import com.karelcode.postgressample.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ControllerTest {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private Controller controller;

    @Test
    public void getById() {
        Mono<Employee> findById = controller.getById(1);

        StepVerifier.create(findById)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void findAll() {
        Flux<Employee> findAllElements = controller.findAll();

        StepVerifier.create(findAllElements)
                .expectNextCount(8)
                .verifyComplete();
    }

    @Test
    public void findByName() {
        Flux<Employee> byName = controller.findByName("Karel");

        StepVerifier.create(byName)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    public void save() {
        Flux<Employee> fluxEmployee = Flux.just("One", "Two", "Three")
                .map(name -> new Employee(null, name))
                .flatMap(employee -> controller.save(employee));

        StepVerifier.create(fluxEmployee)
                .expectNextCount(3)
                .verifyComplete();
    }
}