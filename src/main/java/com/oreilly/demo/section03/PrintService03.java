package com.oreilly.demo.section03;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService03 {

	public Message<?> print(Message<String> message) {
		message.getHeaders().forEach((key, value) -> System.out.println(key + "-" + value));
		System.out.println(message.getPayload());
		return MessageBuilder.withPayload("New Message").build();
	}

}
