package com.oreilly.demo;

import org.springframework.stereotype.Component;

@Component
public class PersonRegistrationService {
    public void registerEmail(Person person) {
        System.out.println("Email created for: " + person.getFirstName());
    }
}
