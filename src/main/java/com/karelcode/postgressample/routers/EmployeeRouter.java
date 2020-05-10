package com.karelcode.postgressample.routers;

import com.karelcode.postgressample.model.Employee;
import com.karelcode.postgressample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

//@Configuration
public class EmployeeRouter {

    /*@Autowired
    public EmployeeRepository employeeRepository;

    @Bean
    public RouterFunction<ServerResponse> getAllEmployee() {
        return route(GET("/allemployee"), request ->
            ok().body(
                    employeeRepository.findAll(), Employee.class)
        );
    }*/

    /*@Bean
    public RouterFunction<ServerResponse> getByIdEmployee(Integer id) {
        return route(GET("/employee/{id}"), serverRequest ->
                ok().body(
                        employeeRepository.findById(id), Employee.class)
        );
    }*/
}
