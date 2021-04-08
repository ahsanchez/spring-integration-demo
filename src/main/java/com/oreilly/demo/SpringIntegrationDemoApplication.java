package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private PrinterGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        //  Object mybridge = ((AnnotationConfigApplicationContext) this.context).getBeanDefinition("mybridge").getPropertyValues().getPropertyValues()[0].getValue();
        // BridgeHandler bridgeHandler = (BridgeHandler) ((AnnotationConfigApplicationContext) this.context).getBeanDefinition("mybridge").getPropertyValues().getPropertyValues()[0].getValue();;
        /* Direct channel */
        for (int i = 0; i < 10; i++) {
            Message<String> message = MessageBuilder
                    .withPayload("Printing message payload for " + i)
                    .setHeader("messageNumber", i)
                    .build();
            this.gateway.print(message);
        }
    }


}
