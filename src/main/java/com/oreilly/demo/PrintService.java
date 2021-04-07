package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class PrintService {

	@ServiceActivator(inputChannel = "inputChannel")
	public void print(Message<String> message) {
		System.out.println(message.getPayload());
	}

	@ServiceActivator(inputChannel = "inputChannel")
	public void printUpper(Message<String> message) {
		System.out.println(message.getPayload().toUpperCase());
	}

}
