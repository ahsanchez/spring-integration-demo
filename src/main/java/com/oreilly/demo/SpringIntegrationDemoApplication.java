package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("integration-context.xml")
public class SpringIntegrationDemoApplication implements ApplicationRunner {

    private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><people>" +
            "<person><firstName>Kevin</firstName><lastName>Bowersox</lastName></person>" +
            "<person><firstName>John</firstName><lastName>Doe</lastName></person>" +
            "</people>";

    @Autowired
    private SimpleGateway gateway;

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationDemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.gateway.execute(xml);
    }

}
