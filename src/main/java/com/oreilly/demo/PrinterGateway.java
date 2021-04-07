package com.oreilly.demo;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@MessagingGateway(defaultRequestChannel = "inputChannel")
@Qualifier("printerGateway")
public interface PrinterGateway {
    @Gateway(requestChannel = "inputChannel")
    Future<Message<String>> print (Message<?> message);
}
