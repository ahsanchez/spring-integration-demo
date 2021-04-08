package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.router.HeaderValueRouter;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableIntegration
@ComponentScan
@IntegrationComponentScan
public class BeanConfiguration {
    @Bean
    public DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    @Autowired
    public EventDrivenConsumer eventDrivenConsumer(DirectChannel inputChannel, HeaderValueRouter headerValueRouter) {
        return new EventDrivenConsumer(inputChannel, headerValueRouter);
    }

    @Bean
    public HeaderValueRouter headerValueRouter() {
        HeaderValueRouter headerValueRouter = new HeaderValueRouter("routeHeader");
        Map<String, String> channelMappings = new HashMap<>();
        channelMappings.put("int", "intChannel");
        channelMappings.put("string", "stringChannel");
        headerValueRouter.setChannelMappings(channelMappings);
        return headerValueRouter;
    }
/*
    @Bean
    public PayloadTypeRouter payloadTypeRouter() {
        PayloadTypeRouter payloadTypeRouter = new PayloadTypeRouter();
        Map<String, String> channelMappings = new HashMap<>();
        channelMappings.put("java.lang.Integer", "intChannel");
        channelMappings.put("java.lang.String", "stringChannel");
        payloadTypeRouter.setChannelMappings(channelMappings);

        return payloadTypeRouter;
    }*/

}
