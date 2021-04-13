package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.concurrent.ExecutionException;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {
        Person[] payloads = {new Person("Ana", "Hinojosa"), new Person("Pilar", "Molina"), new Person("Jose Carlos", "Mendoza")};
        for (Person payload : payloads) {
            Message<?> message = MessageBuilder.withPayload(payload).setHeader("privateKey", "12345").build();
            this.gateway.print(message);
        }

    }
}
