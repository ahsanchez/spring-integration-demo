package com.oreilly.demo;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context-03.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        PrintService service = new PrintService();
        service.print("Hello World");

    }
}
