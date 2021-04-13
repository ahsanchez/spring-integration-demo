package com.oreilly.demo;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class UppercaseService {
    public String execute(Person person) {
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
    }
}
