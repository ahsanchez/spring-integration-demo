package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    @Qualifier("inputChannel")
    private DirectChannel inputChannel;

    @Autowired
    @Qualifier("outputChannel")
    private DirectChannel outputChannel;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {

        // Part 1.
        /* Map<String, Object> map = new HashMap<String, Object>();
        map.put("key", "value");
        MessageHeaders headers = new MessageHeaders(map);
        Message<String> message = MessageBuilder.withPayload("Hello World, from the builder pattern").setHeader("newHeader", "newHeaderValue").build();
        PrintService03 service = new PrintService03();
        service.print(message);*/

        // Part 2.
        /*
        Message<String> message = MessageBuilder.withPayload("Hello World, from the builder pattern").setHeader("newHeader", "newHeaderValue").build();
        PrintService03 service = new PrintService03();
        service.print(message);
         */

        /* Part 3.
        channel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                new PrintService03().print((Message<String>) message);
            }
        });

        Message<String> message = MessageBuilder.withPayload("Hello World, from the builder pattern").setHeader("newHeader", "newHeaderValue").build();
        channel.send(message);

         */

        outputChannel.subscribe(new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                System.out.println(message.getPayload());
            }
        });

        Message<String> message = MessageBuilder.withPayload("Hello World, from the builder pattern").setHeader("newHeader", "newHeaderValue").build();
        inputChannel.send(message);

    }
}
