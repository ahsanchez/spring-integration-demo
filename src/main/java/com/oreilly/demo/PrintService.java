package com.oreilly.demo;

import org.springframework.messaging.Message;

public class PrintService {

    public void print(Message<?> message) {
        System.out.println(message.getPayload());
        message.getHeaders().forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
