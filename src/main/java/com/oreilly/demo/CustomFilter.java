package com.oreilly.demo;

import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("customFilter")
public class CustomFilter implements MessageSelector {
    @Override
    public boolean accept(Message<?> message) {
        return message.getPayload().equals(7);
    }
}
