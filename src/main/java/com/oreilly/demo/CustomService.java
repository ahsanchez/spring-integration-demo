package com.oreilly.demo;

import org.springframework.stereotype.Component;

@Component
public class CustomService {
    public String getPhoneNumber(Person person) {
        return "867-5309";
    }
}
