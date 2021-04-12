package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component("customRouter")
public class CustomRouter extends AbstractMessageRouter {
    @Autowired
    @Qualifier("intChannel")
    private DirectChannel intChannel;

    @Autowired
    @Qualifier("stringChannel")
    private DirectChannel stringChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> targetChannels = new ArrayList<>();
        if (message.getPayload().getClass().equals(Integer.class)) {
            targetChannels.add(intChannel);
        } else if (message.getPayload().getClass().equals(String.class)) {
            targetChannels.add(stringChannel);
        }
        return targetChannels;
    }
}
