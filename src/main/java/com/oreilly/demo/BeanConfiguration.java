package com.oreilly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.endpoint.EventDrivenConsumer;
import org.springframework.integration.filter.ExpressionEvaluatingSelector;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.List;

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
    public EventDrivenConsumer eventDrivenConsumer(DirectChannel inputChannel, RecipientListRouter recipientListRouter) {
        return new EventDrivenConsumer(inputChannel, recipientListRouter);
    }

    @Bean
    @Autowired
    public RecipientListRouter recipientListRouter(MessageChannel intChannel, MessageChannel stringChannel) {
        RecipientListRouter recipientListRouter = new RecipientListRouter();

        ExpressionEvaluatingSelector expressionEvaluatingSelector = new ExpressionEvaluatingSelector("payload.equals(5)");
        expressionEvaluatingSelector.setBeanFactory(new DefaultListableBeanFactory());

        List<RecipientListRouter.Recipient> recipientList = new ArrayList<>();
        recipientList.add(new RecipientListRouter.Recipient(intChannel, expressionEvaluatingSelector));
        recipientList.add(new RecipientListRouter.Recipient(stringChannel));

        recipientListRouter.setRecipients(recipientList);
        return recipientListRouter;
    }


}
