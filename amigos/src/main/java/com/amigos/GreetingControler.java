package com.amigos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class GreetingController {

    @GetMapping("/greet")
    public GreetResponse greet() {
        Person p = new Person("Alex", 28, 30_000); // Added missing semicolon
        GreetResponse res = new GreetResponse("Hello", List.of("Java", "JS", "Golang", "Swift"), p);
        return res;
    }

    record GreetResponse(String greet, List<String> lists, Person person) {} // Corrected record syntax
    record Person(String name, int age, double savings) {}
}
