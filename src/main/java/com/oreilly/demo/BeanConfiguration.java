package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.endpoint.EventDrivenConsumer;

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
    public DirectChannel defaultChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel intChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel stringChannel() {
        return new DirectChannel();
    }

    @Bean
    @Autowired
    public EventDrivenConsumer eventDrivenConsumer(DirectChannel inputChannel, DirectChannel defaultChannel) {
        CustomRouter customRouter = new CustomRouter();
        // customRouter.setDefaultOutputChannel(new DirectChannel());
        return new EventDrivenConsumer(inputChannel, customRouter);
    }

}
