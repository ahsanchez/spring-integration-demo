package com.oreilly.demo;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component("customSplitter")
public class CustomSplitter extends AbstractMessageSplitter {
    @Override
    protected Object splitMessage(Message<?> message) {
        return new ArrayList<String>(Arrays.asList(message.getPayload().toString().split(" ")));
    }
}
