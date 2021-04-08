package com.oreilly.demo;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PrintService {

    @ServiceActivator(inputChannel = "stringChannel")
    public void print(Message<String> message) {
        System.out.println(message.getPayload());
    }

    @ServiceActivator(inputChannel = "intChannel")
    public void printNumeric(Message<?> message) {
        System.out.println("Printing the numeric: " + message.getPayload());
    }

}
