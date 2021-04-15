package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("mp")
public class MessagePrinter {

    public void print(Message<?> message) {
        System.out.println(message);
    }
}
