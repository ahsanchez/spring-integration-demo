package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("mp")
public class MessagePrinter {

    public String print(Message<?> message) {
        return "From the inbound gateway: 1 message worked";
    }

    public void printConsole(Message<?> message) {
        System.out.println("Message was passed to printConsole from the outboundGateway");
        System.out.println(message);
    }
}
