package com.oreilly.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

@Configuration
@EnableIntegration
@ComponentScan
@IntegrationComponentScan
public class BeanConfiguration {

    @Bean
    public MessageChannel inputChannel() {
        return new PublishSubscribeChannel(executor());
    }

    @Bean
    public TaskExecutor executor() {
        TaskExecutorFactoryBean executor = new TaskExecutorFactoryBean();
        executor.setPoolSize("5");
        return executor.getObject();
    }


}
