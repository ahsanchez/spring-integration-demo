package com.oreilly.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonDirectoryService {
    public Person findNewPeople() {
        System.out.println("Inbound Adapter has polled this service.");
        return new Person("Henar", "Lopez");

    }
}
