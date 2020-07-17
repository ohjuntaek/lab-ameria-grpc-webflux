package me.example.demoameria.r2dbc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequiredArgsConstructor
public class IOTestController {

    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final EmployeeRepository employeeRepository;


    @GetMapping("/3second")
    public String threeSecond() throws InterruptedException {
        Thread.sleep(3000);
        return "success - " + this.atomicInteger.incrementAndGet();
    }

    @GetMapping("/hey")
    public Flux<Employee> hey() {

        return employeeRepository.findAll();
    }
}
