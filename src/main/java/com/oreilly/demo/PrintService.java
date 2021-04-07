package com.oreilly.demo;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

	public Message<?> print(Message<String> message) {
		System.out.println(message.getPayload());
		return MessageBuilder.withPayload("Sending a reply for message "+message.getHeaders().get("messageNumber")).build();
	}

}
