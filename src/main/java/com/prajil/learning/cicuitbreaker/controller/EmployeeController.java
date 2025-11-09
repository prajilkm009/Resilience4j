package com.prajil.learning.cicuitbreaker.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value="api/v1/employee")
public class EmployeeController {



    @GetMapping("/details")
    @CircuitBreaker(name = "employeeServiceCircuitBreaker", fallbackMethod = "getEmployeeDetailsFallback")
    public String getEmployeeDetails() {
        return "Employee details";
    }

    public String getEmployeeDetailsFallback(Throwable t) {
        return "Employee details are currently unavailable. Please try again later.";
    }
}
