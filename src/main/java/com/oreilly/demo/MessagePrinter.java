package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("mp")
public class MessagePrinter {

    public String print(Message<?> message) {
        System.out.println("Print the message:");
        System.out.println(message);
        return "1 message worked";
    }
}
