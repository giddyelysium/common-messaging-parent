/**
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 */

package com.dell.cpsd.common.rabbitmq.config;

import javax.annotation.Resource;

import org.aopalliance.aop.Advice;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.retry.MessageRecoverer;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;

import com.dell.cpsd.common.logging.LoggingManager;
import com.dell.cpsd.common.rabbitmq.context.builder.DefaultContainerErrorHandler;
import com.dell.cpsd.common.rabbitmq.retrypolicy.DefaultMessageRecoverer;
import com.dell.cpsd.common.rabbitmq.retrypolicy.DefaultRetryPolicy;
import com.dell.cpsd.common.rabbitmq.retrypolicy.DefaultRetryPolicyAdvice;

/**
 * Configures AMQP message consumers.
 * <p>
 * Copyright &copy; 2017 Dell Inc. or its subsidiaries. All Rights Reserved. Dell EMC Confidential/Proprietary Information
 * </p>
 */
@Configuration
public class ConsumerConfig
{
    @Autowired
    @Qualifier("rabbitConnectionFactory")
    private ConnectionFactory rabbitConnectionFactory;

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate    rabbitTemplate;

    @Autowired
    private Queue             responseQueue;

    @Autowired
    MessageConverter          messageConverter;

    /**
     * creates bean for SimpleMessageListenerContainer
     * 
     * @return {@link SimpleMessageListenerContainer}
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer()
    {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory);
        container.setAcknowledgeMode(AcknowledgeMode.AUTO);
        container.setQueues(responseQueue);
        container.setAdviceChain(new Advice[] {retryPolicyAdvice()});
        container.setErrorHandler(new DefaultContainerErrorHandler("simpleMessageListenerContainer"));
        return container;
    }

    /**
     * LoggingManager bean to create logger class
     * 
     * @return LoggingManager
     */
    @Bean
    public LoggingManager loggingManager()
    {
        return new LoggingManager();
    }

    /**
     * Creates bean for simpleRabbitListenerContainerFactory
     * 
     * @param connectionFactory
     *            - {@link ConnectionFactory}
     * @return SimpleRabbitListenerContainerFactory - {@link SimpleRabbitListenerContainerFactory}
     */
    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> rabbitListenerContainerFactory()
    {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
        factory.setAdviceChain(new Advice[] {retryPolicyAdvice()});
        factory.setErrorHandler(new DefaultContainerErrorHandler("simpleRabbitListenerContainerFactory"));
        factory.setMessageConverter(messageConverter);
        return factory;
    }

    /**
     * Create beans for DefaultRetryPolicyAdvice
     * 
     * @return {@link Advice}
     */
    @Bean
    public Advice retryPolicyAdvice()
    {
        MessageRecoverer messageRecoverer = new DefaultMessageRecoverer(rabbitTemplate);
        return new DefaultRetryPolicyAdvice(messageRecoverer, retryPolicy());
    }

    /**
     * creates bean for DefaultRetryPolicy
     * 
     * @return {@link RetryPolicy}
     */
    @Bean
    public RetryPolicy retryPolicy()
    {
        return new DefaultRetryPolicy();
    }

    /**
     * Creates bean for HandlerRegistrar
     * 
     * @return {@link HandlerRegistrar}
     */
    @Bean
    public HandlerRegistrar handlerRegistrar()
    {
        return new HandlerRegistrar();
    }
}