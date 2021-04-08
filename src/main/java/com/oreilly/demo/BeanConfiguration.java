package com.oreilly.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.config.TaskExecutorFactoryBean;

@Configuration
@EnableIntegration
@ComponentScan
@IntegrationComponentScan
public class BeanConfiguration {

    @Bean
    public PublishSubscribeChannel inputChannel() {
        return new PublishSubscribeChannel(executor());
    }

    @Bean
    public QueueChannel pollChannel() {
        return new QueueChannel(10);
    }

    @Bean
    public TaskExecutor executor() {
        TaskExecutorFactoryBean executor = new TaskExecutorFactoryBean();
        executor.setPoolSize("5");
        return executor.getObject();
    }
/*
    @Bean
    @Autowired
    public ConsumerEndpointFactoryBean bridge(PublishSubscribeChannel inputChannel, QueueChannel pollChannel) {
        ConsumerEndpointFactoryBean consumerEndpointFactoryBean = new ConsumerEndpointFactoryBean();
        consumerEndpointFactoryBean.setInputChannel(pollChannel);
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setMaxMessagesPerPoll(2);
        consumerEndpointFactoryBean.setPollerMetadata(pollerMetadata);
        BridgeHandler bridgeHandler = new BridgeHandler();
        bridgeHandler.setOutputChannel(inputChannel);
        consumerEndpointFactoryBean.setHandler(bridgeHandler);
        PollingConsumer pollingConsumer = new PollingConsumer();
        return consumerEndpointFactoryBean;
    }*/


}
