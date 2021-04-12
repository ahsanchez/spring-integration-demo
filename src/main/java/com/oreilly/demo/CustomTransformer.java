package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class CustomTransformer {
    public String transform(Message<String> message) {
        String tokens[] = message.getPayload().split(" ");
        return tokens[1] + ", " + tokens[0];
    }
}
