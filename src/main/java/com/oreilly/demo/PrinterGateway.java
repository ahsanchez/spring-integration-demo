package com.oreilly.demo;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway(defaultRequestChannel = "pollChannel")
@Qualifier("printerGateway")
public interface PrinterGateway {
    @Gateway(requestChannel = "pollChannel")
    public void print(Message<?> message);
}
