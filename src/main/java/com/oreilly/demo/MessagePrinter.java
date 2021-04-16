package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("printer")
public class MessagePrinter {

    public String print(Message<?> message) {
        System.out.println("Message printer is working the message");
        return "From the inbound gateway: 1 message worked";
    }

    public void printConsole(Message<?> message) {
        System.out.println("Message was passed to printConsole method");
        System.out.println(message);
    }
}
